package arrayAndString;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length == 0)
            return res;
        helper(nums, res, 1, 0);
        return res;
    }

    private int helper(int[] nums, int[] res, int left, int i) {
        if(i == nums.length - 1) {
            res[i] = left;
            return nums[i];
        }
        int right = helper(nums, res, left * nums[i], i + 1);
        res[i] = left * right;
        return right * nums[i];
    }
}
