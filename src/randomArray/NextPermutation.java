package randomArray;

import java.util.*;

public class NextPermutation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<int[]> list = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        list.add(nums);
        boolean flag = false;
        for(int i = 0; !flag; i++) {
            int[] elem = nextPermutation(Arrays.copyOf(list.get(i), list.get(i).length));
            if(elem != null)
                list.add(elem);
            else
                flag = true;
        }

        for(int[] x : list) {
            System.out.println(Arrays.toString(x));
//            for(int y : x)
//                System.out.print(y + " ");
//            System.out.println();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if(i < 0)
           return null;
        else {
            int j = nums.length - 1;
            while (nums[i] >= nums[j])
                j--;
            swap(nums, i, j);
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right)
                swap(nums, left++, right--);
        }
        return nums;
    }

//    public static List<Integer> nextPermutation(List<Integer> nums) {
//        int i = nums.size() - 2;
//        while(i >= 0 && nums.get(i) >= nums.get(i + 1))
//            i--;
//        if(i < 0)
//            return null;
//        else {
//            int j = nums.size() - 1;
//            while (nums.get(i) >= nums.get(j))
//                j--;
//            swap(nums, i, j);
//            int left = i + 1;
//            int right = nums.size() - 1;
//            while (left < right)
//                swap(nums, left++, right--);
//        }
//        return nums;
//    }

//    public void nextPermutation(int[] nums) {
//        int i = nums.length - 2;
//        while(i >= 0 && nums[i] >= nums[i + 1])
//            i--;
//        if(i < 0) {
//            int left = 0;
//            int right = nums.length - 1;
//            while(left < right)
//                swap(nums, left++, right--);
//        }
//        else {
//            int j = nums.length - 1;
//            while (nums[i] >= nums[j])
//                j--;
//            swap(nums, i, j);
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right)
//                swap(nums, left++, right--);
//        }
//    }

    public static void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }
}