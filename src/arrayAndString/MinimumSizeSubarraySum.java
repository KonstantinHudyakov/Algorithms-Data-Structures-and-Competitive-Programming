package arrayAndString;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        int res = obj.minSubArrayLen(7, nums);
        System.out.println(res);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum += nums[right++];
            while(sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

//213
//12 28 83 4 25 26 25 2 25 25 25 12
//2 4 12 12 25 25 25 25 25 26 28 83
