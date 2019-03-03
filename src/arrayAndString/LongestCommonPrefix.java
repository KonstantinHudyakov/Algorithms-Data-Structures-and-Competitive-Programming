package arrayAndString;

public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int maxLength = Integer.MAX_VALUE;
        for(String s : strs) {
            if(s.length() < maxLength)
                maxLength = s.length();
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < maxLength; i++) {
            char ch = strs[0].charAt(i);
            for(String s : strs) {
                if(s.charAt(i) != ch)
                    return res.toString();
            }
            res.append(ch);
        }
        return res.toString();
    }
}
