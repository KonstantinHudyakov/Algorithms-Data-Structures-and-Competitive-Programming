package arrayAndString;

public class ReverseString {
    public static void main(String[] args) {

    }

    public String reverseString(String s) {
        char[] str = s.toCharArray();
        for(int i = 0, j = str.length - 1; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        return String.valueOf(str);
    }
}
