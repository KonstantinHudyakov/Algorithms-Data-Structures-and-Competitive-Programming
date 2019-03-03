package dynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int[] nums = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        //int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int res = obj.rob(nums);
        System.out.println(res);
    }

    public int rob(int[] nums) {
        int[] mem = new int[nums.length + 1];
        Arrays.fill(mem, -1);
        return robRecursive(nums, mem,nums.length - 1);
    }

    private int robRecursive(int[] nums, int[] mem, int i) {
        if(i < 0)
            return 0;
        if(mem[i] != -1)
            return mem[i];
        int res = Math.max(robRecursive(nums, mem,i - 2) + nums[i], robRecursive(nums, mem, i - 1));
        mem[i] = res;
        return res;
    }
}