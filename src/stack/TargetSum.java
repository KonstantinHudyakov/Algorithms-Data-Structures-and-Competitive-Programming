package stack;

public class TargetSum {
    public static void main(String[] args) {
        TargetSum obj = new TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int res = obj.findTargetSumWays(nums, 3);
        System.out.println(res);
    }

    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWaysRecursive(nums, S, 0, 0);
    }

    public int findTargetSumWaysRecursive(int[] nums, int target, int i, int sum) {
        if(i == nums.length)
            return sum == target ? 1 : 0;
        int count = findTargetSumWaysRecursive(nums, target, i + 1, sum + nums[i]);
        count += findTargetSumWaysRecursive(nums, target, i + 1, sum - nums[i]);
        return count;
    }
}
