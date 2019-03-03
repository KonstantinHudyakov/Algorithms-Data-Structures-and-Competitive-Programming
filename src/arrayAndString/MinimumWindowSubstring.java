package arrayAndString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String res = obj.minWindow("ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country", "ask_country");
        System.out.println(res);
    }

    //wrong
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        if(t.length() == 1 || s.length() == 1) {
            if(s.contains(t))
                return t;
            else
                return "";
        }
        Map<Character, Integer> set = new HashMap<>();
        for(int i = 0; i < t.length(); i++)
            set.put(t.charAt(i), set.getOrDefault(t.charAt(i), 0) + 1);
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(set.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(char x : set.keySet()) {
            if(map.getOrDefault(x, 0) < set.get(x))
                return "";
        }

        int[] cords = recursion(s, set, map, 0, s.length() - 1);
        return s.substring(cords[0], cords[1] + 1);
    }

    private int[] recursion(String s, Map<Character, Integer> set, Map<Character, Integer> map, int i, int j) {
        while(true) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(set.containsKey(left) && set.containsKey(right)) {
                if(map.get(left) == set.get(left) && map.get(right) == set.get(right))
                    return new int[] {i, j};
                else if(map.get(left) > set.get(left) && map.get(right) > set.get(right)) {
                    if(left == right) {
//                        if(map.get(left) - set.get(left) >= 2) {
//                            map.put(left, map.get(left) - 2);
//                            return recursion(s, set, new HashMap<>(map), i + 1, j - 1);
//                        }
//                        else {
                            map.put(left, map.get(left) - 1);
                            int[] one = recursion(s, set, new HashMap<>(map), i + 1, j);
                            int[] sec = recursion(s, set, new HashMap<>(map), i, j - 1);
                            if(sec[1] - sec[0] < one[1] - one[0])
                                return sec;
                            else
                                return one;
                        }
                    map.put(left, map.get(left) - 1);
                    int[] one = recursion(s, set, new HashMap<>(map), i + 1, j);
                    map.put(left, map.get(left) + 1);
                    map.put(right, map.get(right) - 1);
                    int[] sec = recursion(s, set, new HashMap<>(map), i, j - 1);
                    if(sec[1] - sec[0] < one[1] - one[0])
                        return sec;
                    else
                        return one;
                }
                else if(map.get(left) > set.get(left)) {
                    map.put(left, map.get(left) - 1);
                    i++;
                }
                else {
                    map.put(right, map.get(right) - 1);
                    j--;
                }
            }
            else if(!set.containsKey(left) && !set.containsKey(right)) {
                i++;
                j--;
            }
            else if(set.containsKey(right))
                i++;
            else if(set.containsKey(left))
                j--;
        }
    }
}
