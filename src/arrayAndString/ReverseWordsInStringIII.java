package arrayAndString;

public class ReverseWordsInStringIII {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        if(words.length == 0)
            return "";
        StringBuilder str = new StringBuilder();
        str.append(getReversedString(words[0]));
        for(int i = 1; i < words.length; i++) {
            str.append(" ");
            str.append(getReversedString(words[i]));
        }
        return str.toString();
    }

    private String getReversedString(String s) {
        char[] str = s.toCharArray();
        for(int i = 0, j = str.length - 1; i < j; i++, j--) {
            char a = str[i];
            str[i] = str[j];
            str[j] = a;
        }
        return String.valueOf(str);
    }
}
