package hashTable;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            String sorted = getSortedString(s);
            if(map.containsKey(sorted))
                map.get(sorted).add(s);
            else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(sorted, temp);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String getSortedString(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return String.copyValueOf(temp);
    }
}
