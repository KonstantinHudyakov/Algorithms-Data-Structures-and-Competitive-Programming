package arrayAndString;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        String max = String.valueOf(s.charAt(0));
        char[] str = s.toCharArray();
        for(int mid = 1; mid < str.length; mid++) {
            int left = mid;
            int right = mid;
            while(left - 1 >= 0 && right + 1 < str.length && str[left - 1] == str[right + 1]) {
                left--;
                right++;
            }
            if(left >= 0 && right < str.length && right - left + 1 > max.length())
                max = s.substring(left, right + 1);
        }
        for(int mid = 1; mid < str.length; mid++) {
            if(str[mid] == str[mid - 1]) {
                int left = mid - 1;
                int right = mid;
                while(left - 1 >= 0 && right + 1 < str.length && str[left - 1] == str[right + 1]) {
                    left--;
                    right++;
                }
                if(left >= 0 && right < str.length && right - left + 1 > max.length())
                    max = s.substring(left, right + 1);
            }
        }
        return max;
    }
}
