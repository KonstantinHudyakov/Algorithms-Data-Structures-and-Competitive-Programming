package arrayAndString;

import java.util.*;

public class ShuffleAnArray {
    public static void main(String[] args) {

    }

    private int[] nums;
    private int[] copy;
    Map<Integer, Set<Integer>> map;

    public ShuffleAnArray(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
        copy = Arrays.copyOf(nums, nums.length);
        map = new HashMap<>();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = Arrays.copyOf(copy, copy.length);
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums.length == 0)
            return nums;
        if(isFull())
            map.clear();

        int i = (int) (Math.random() * 10000) % nums.length;
        map.putIfAbsent(i, new HashSet<>());
        while(map.get(i).size() == nums.length - 1) {
            i = (int) (Math.random() * 10000) % nums.length;
            map.putIfAbsent(i, new HashSet<>());
        }

        int j = (int) (Math.random() * 10000) % nums.length;
        while (map.get(i).contains(j) && j == i)
            j = (int) (Math.random() * 10000) % nums.length;

        map.get(i).add(j);
        swap(i, j);
        return nums;
    }

    private boolean isFull() {
        if(map.keySet().size() != nums.length)
            return false;
        else {
            for(int key : map.keySet()) {
                if(map.get(key).size() != nums.length - 1)
                    return false;
            }
        }
        return true;
    }

    private void swap(int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }
}
