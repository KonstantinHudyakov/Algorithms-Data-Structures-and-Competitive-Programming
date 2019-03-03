package arrayAndString;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        int prev = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int temp = map.get(s.charAt(i));
            if(temp < prev)
                res -= temp;
            else
                res += temp;
            prev = temp;
        }
        return res;
    }
}
