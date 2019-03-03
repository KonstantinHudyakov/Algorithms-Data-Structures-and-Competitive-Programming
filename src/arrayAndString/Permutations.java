package arrayAndString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 1)
            return res;
        for(int i = 0; i < nums.length; i++)
            generatePermutations(nums, res, new ArrayList<>(), new HashSet<>(), i);
        return res;
    }

    private void generatePermutations(int[] nums, List<List<Integer>> list, List<Integer> comb, Set<Integer> visited, int curr) {
        comb.add(nums[curr]);
        visited.add(curr);
        if(visited.size() == nums.length) {
            list.add(comb);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited.contains(i))
                generatePermutations(nums, list, new ArrayList<>(comb), new HashSet<>(visited), i);
        }
    }
}
