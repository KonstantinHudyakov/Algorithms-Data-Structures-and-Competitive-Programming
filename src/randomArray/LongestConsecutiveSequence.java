package randomArray;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            int curr = 1;
            for(int j = 1; set.contains(nums[i] - j); j++)
                curr++;
            for(int j = 1; set.contains(nums[i] + j); j++)
                curr++;
            set.add(nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
}
