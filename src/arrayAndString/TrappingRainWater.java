package arrayAndString;

public class TrappingRainWater {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        int start = 0;
        while(start + 1 < height.length && height[start] <= height[start + 1])
            start++;
        int end = height.length - 1;
        while(end - 1 >= 0 && height[end] <= height[end - 1])
            end--;
        return helper(height, start, end);
    }

    private int helper(int[] nums, int i, int j) {
        int water = 0;
        int max = i++;
        for(; i <= j; i++) {
            if(nums[i] >= nums[max]) {
                int level = Math.min(nums[i], nums[max]);
                for(int k = max + 1; k < i; k++)
                    water += level - nums[k];
                max = i;
            }
        }
        if(i - 1 != max)
            water += rightToLeft(nums, max, j);
        return water;
    }

    private int rightToLeft(int[] nums, int i, int j) {
        int water = 0;
        int max = j--;
        for(; i <= j; j--) {
            if(nums[j] >= nums[max]) {
                int level = Math.min(nums[j], nums[max]);
                for(int k = max - 1; k > j; k--)
                    water += level - nums[k];
                max = j;
            }
        }
        return water;
    }
}
