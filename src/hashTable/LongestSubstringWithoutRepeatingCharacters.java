package hashTable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                int val = map.get(ch);
                if(val >= start)
                    start = val + 1;
            }
            if(i - start + 1 > max)
                max = i - start + 1;
            map.put(ch, i);
        }
        return max;
    }
}
