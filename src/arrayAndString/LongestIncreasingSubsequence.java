package arrayAndString;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }

    static int longestIncreasingSubsequence(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int maxLength = 1;
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j];
                }
            }
            dp[i]++;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
