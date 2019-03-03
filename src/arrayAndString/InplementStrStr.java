package arrayAndString;

public class InplementStrStr {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0) && checkStr(haystack, needle, i))
                return i;
        }
        return -1;
    }

    private boolean checkStr(String str, String sub, int index) {
        int j = 1;
        for(; j < sub.length() && index + j < str.length(); j++) {
            if(str.charAt(index + j) != sub.charAt(j))
                return false;
        }
        return index + j < str.length() || j == sub.length();
    }
}
