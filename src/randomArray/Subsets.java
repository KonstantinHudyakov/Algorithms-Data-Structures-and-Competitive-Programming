package randomArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = obj.subsets(nums);

        for(List<Integer> x : list) {
            for(Integer y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        addToSet(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public void addToSet(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
        list.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            addToSet(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
