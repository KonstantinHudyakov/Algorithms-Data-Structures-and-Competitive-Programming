package binarySearch;

public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int res = obj.findPeakElement(nums);
        System.out.println(res);
    }

    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        if(nums[0] > nums[1])
                return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;
        return findPeakElementRecursive(nums, 1, nums.length - 2);
    }

    public int findPeakElementTemplate3(int[] nums) {
        if(nums.length == 1)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if(nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        if(nums[left] > nums[right])
            return left;
        else
            return right;
    }

    public int findPeakElementRecursive(int[] nums, int left, int right) {
        if(left > right)
            return -1;
        else {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            int a = findPeakElementRecursive(nums, left, mid - 1);
            if(a != -1)
                return a;
            return findPeakElementRecursive(nums, mid + 1, right);
        }
    }
}

