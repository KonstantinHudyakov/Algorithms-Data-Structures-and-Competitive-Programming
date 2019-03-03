package randomArray;

public class MaximumProductSubarray {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int prevMin = nums[0];
        int prevMax = nums[0];
        int maxProd = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int maxToCur = Math.max(nums[i], Math.max(prevMax * nums[i], prevMin * nums[i]));
            int minToCur = Math.min(nums[i], Math.min(prevMax * nums[i], prevMin * nums[i]));
            maxProd = Math.max(maxProd, maxToCur);
            prevMax = maxToCur;
            prevMin = minToCur;
        }
        return maxProd;
    }
}
