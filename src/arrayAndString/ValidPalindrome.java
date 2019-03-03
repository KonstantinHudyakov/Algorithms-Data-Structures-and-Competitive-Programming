package arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch))
                list.add(Character.toLowerCase(ch));
        }
        for(int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if(list.get(i) != list.get(j))
                return false;
        }
        return true;
    }
}

