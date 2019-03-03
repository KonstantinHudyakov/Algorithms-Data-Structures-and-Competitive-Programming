package hashTable;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int x : nums1)
            set.add(x);
        for(int x : nums2) {
            if(set.contains(x))
                result.add(x);
        }
        int[] arr = new int[result.size()];
        int i = 0;
        for(int x : result)
            arr[i++] = x;
        return arr;
    }
}
