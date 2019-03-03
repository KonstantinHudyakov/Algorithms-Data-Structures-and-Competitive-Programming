package arrayAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        List<String> comb = new ArrayList<>();
        if(digits.length() == 0)
            return comb;
        Map<Character, List<Character>> map = createMap();
        generateCombinations(digits, map, comb, "", 0);
        return comb;
    }

    private Map<Character, List<Character>> createMap() {
        Map<Character, List<Character>> map = new HashMap<>();
        char ch = 'a';
        for(char num = '2'; num <= '9'; num++) {
            List<Character> list = new ArrayList<>();
            int count = num == '7' || num == '9' ? 4 : 3;
            for(int i = 0; i < count; i++) {
                list.add(ch);
                ch++;
            }
            map.put(num, list);
        }
        return map;
    }

    private void generateCombinations(String digits, Map<Character, List<Character>> map, List<String> comb, String curr, int i) {
        if(i >= digits.length()) {
            comb.add(curr);
            return;
        }
        for(char ch : map.get(digits.charAt(i)))
            generateCombinations(digits, map, comb, curr + ch, i + 1);
    }
}
