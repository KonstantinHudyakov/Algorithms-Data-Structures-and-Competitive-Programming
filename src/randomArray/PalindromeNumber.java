package randomArray;

public class PalindromeNumber {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int j = s.length() - 1;
        boolean flag = true;
        for(int i = 0; i < j && flag; i++, j--) {
            if(s.charAt(i) != s.charAt(j))
                flag = false;
        }
        return flag;
    }
}
