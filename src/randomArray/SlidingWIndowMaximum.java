package randomArray;

public class SlidingWIndowMaximum {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[0];
        k--;
        int[] res = new int[nums.length - k];
        int max = -1;
        for(int i = k; i < nums.length; i++) {
            if(max == -1) {
                max = i - k;
                for (int j = i - k + 1; j <= i; j++) {
                    if (nums[j] > nums[max])
                        max = j;
                }
            }
            else if(nums[i] > nums[max])
                max = i;
            res[i - k] = nums[max];
            if(max == i - k)
                max = -1;
        }
        return res;
    }
}
