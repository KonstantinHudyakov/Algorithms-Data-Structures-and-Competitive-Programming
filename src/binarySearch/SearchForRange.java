package binarySearch;

public class SearchForRange {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[] {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        boolean flag = false;
        while(!flag && left < right) {
            int mid = left + (right - left) / 2;
            if(nums[left] == target && nums[right] == target)
                flag = true;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        if(nums[left] != target)
            return new int[] {-1, -1};
        while(left - 1 >= 0 && nums[left] == nums[left - 1])
            left--;
        while(right + 1 < nums.length && nums[right] == nums[right + 1])
            right++;
        return new int[] {left, right};
    }
}
