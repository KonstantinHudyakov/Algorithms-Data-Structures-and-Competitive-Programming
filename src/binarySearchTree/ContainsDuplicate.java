package binarySearchTree;

public class ContainsDuplicate {
    public static void main(String[] args) {

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k == 0)
            return false;
        boolean result = false;
        for(int i = 0; !result && i < nums.length; i++) {
            for(int j = i + 1; !result && j <= Math.min(i + k, nums.length - 1); j++) {
                if(Math.abs((long)nums[i] - nums[j]) <= t)
                    result = true;
            }
        }
        return result;
    }
}