package arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();
        String res = obj.reverseWords("the sky is blue");
        System.out.println(res);
    }

    public String reverseWords(String s) {
        if(s.equals(""))
            return "";
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i >= 0 && i < s.length()) {
            i = firstLetterIndex(s, i);
            if(i != -2) {
                int spaceIndex = s.indexOf(' ', i);
                if(spaceIndex != -1) {
                    list.add(s.substring(i, spaceIndex));
                    i = spaceIndex + 1;
                }
                else {
                    list.add(s.substring(i));
                    i = -2;
                }
            }
        }
        StringBuilder str = new StringBuilder();
        if(list.isEmpty())
            return "";
        str.append(list.get(list.size() - 1));
        for(int j = list.size() - 2; j >= 0; j--) {
            str.append(" ");
            str.append(list.get(j));
        }
        return str.toString();
    }

    private int firstLetterIndex (String s, int from) {
        for(int i = from; i < s.length(); i++)
            if(s.charAt(i) != ' ')
                return i;
        return -2;
    }

    //public String reverseWords(String s) {
    //    String[] words = s.trim().split(" +");
    //    Collections.reverse(Arrays.asList(words));
    //    return String.join(" ", words);
    //}
}
