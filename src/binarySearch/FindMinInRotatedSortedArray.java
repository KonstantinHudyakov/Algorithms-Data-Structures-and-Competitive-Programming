package binarySearch;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        FindMinInRotatedSortedArray obj = new FindMinInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int res = obj.findMin(nums);
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}
