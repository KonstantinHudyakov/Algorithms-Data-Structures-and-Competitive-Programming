package binarySearch;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> temp = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int x : nums1)
            temp.add(x);
        for(int x : nums2) {
            if(temp.contains(x))
                set.add(x);
        }
        return set.stream().filter(t -> t != null).mapToInt(t -> t).toArray();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int x : nums1)
            temp.add(x);
        for(int i = 0; i < nums2.length; i++) {
            if(temp.contains(nums2[i])) {
                list.add(nums2[i]);
                temp.remove(temp.indexOf(nums2[i]));
            }
        }
        return list.stream().filter(t -> t != null).mapToInt(t -> t).toArray();
    }
}
