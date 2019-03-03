package arrayAndString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        char[] sStr = s.toCharArray();
        char[] tStr = t.toCharArray();
        Arrays.sort(sStr);
        Arrays.sort(tStr);
        return String.valueOf(sStr).equals(String.valueOf(tStr));
    }
}
