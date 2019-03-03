package arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void generateSubsets(int[] nums, List<List<Integer>> list, List<Integer> subset, int i) {
        list.add(subset);
        for(; i < nums.length; i++) {
            subset.add(nums[i]);
            generateSubsets(nums, list, new ArrayList<>(subset), i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
