package other;

public class DecodeWays {
    public static void main(String[] args) {

    }

    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0')
            return 0;
        boolean[] res = new boolean[1];
        int ans = helper(s, 0, res);
        if(res[0])
            return 0;
        else
            return ans;
    }

    private int helper(String s, int i, boolean[] res) {
        if(res[0])
            return 0;
        int ways = 1;
        for(int j = i + 1; j < s.length(); j++) {
            char prev = s.charAt(j - 1);
            if(s.charAt(j) == '0') {
                if(j == s.length() - 1)
                    return ways;
                else {
                    res[0] = true;
                    return 0;
                }
            }
            if(prev <= '2') {
                if(Integer.parseInt(String.valueOf(prev) + String.valueOf(s.charAt(j))) <= 26) {
                    ways += helper(s, j, res);
                    j++;
                }
            }
        }
        return ways;
    }
}
