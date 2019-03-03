package hashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int addition = target - nums[i];
            if(map.containsKey(addition)) {
                int index = map.get(addition);
                if(index != i)
                    return new int[] {i, index};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
