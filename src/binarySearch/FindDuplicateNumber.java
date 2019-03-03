package binarySearch;

import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[mid + 1])
                return nums[mid];
            if(nums[mid] >= mid + 1)
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}