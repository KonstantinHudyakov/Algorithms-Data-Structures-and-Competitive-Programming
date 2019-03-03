package arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {

    }

    public int dominantIndex(int[] nums) {
        List<Integer> lower = new ArrayList<>();
        int max = 0;
        boolean res = true;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[max]) {
                if(nums[i] < nums[max] * 2)
                    lower.add(nums[max]);
                max = i;
            } else if(nums[max] < nums[i] * 2)
                lower.add(nums[i]);
        }
        for(int x : lower)
            if(nums[max] < x * 2)
                return -1;
        return max;
    }
}
