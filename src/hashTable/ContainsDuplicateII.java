package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(findK(map.get(nums[i]), i, k))
                    return true;
                else
                    map.get(nums[i]).add(i);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i], temp);
            }
        }
        return false;
    }

    private boolean findK(List<Integer> list, int i, int k) {
        for(int x : list)
            if(Math.abs(x - i) <= k)
                return true;
        return false;
    }
}
