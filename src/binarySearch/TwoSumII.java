package binarySearch;

public class TwoSumII {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++) {
            int second = binarySearch(numbers, target - numbers[i]);
            if(second != -1 && second != i) {
                if (i < second)
                    return new int[]{i + 1, second + 1};
                else
                    return new int[]{second + 1, i + 1};
            }
        }
        return null;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
