package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {

    }
    // 1 2 3 4 5 6 7 8 9 0

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0) {
            if(nums2.length % 2 == 0)
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
            else
                return nums2[nums2.length / 2];
        }
        if(nums2.length == 0) {
            if(nums1.length % 2 == 0)
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
            else
                return nums1[nums1.length / 2];
        }
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < nums1.length || j < nums2.length) {
            if(i < nums1.length && j < nums2.length) {
                if(nums1[i] < nums2[j])
                    list.add(nums1[i++]);
                else
                    list.add(nums2[j++]);
            }
            else if(i < nums1.length)
                list.add(nums1[i++]);
            else if(j < nums2.length)
                list.add(nums2[j++]);
        }
        if(list.size() % 2 == 0)
            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
        else
            return list.get(list.size() / 2);
    }
}
//1 3 5 6 23 49
//1 4 6 9 10 11
//1 1 3 4 5 6 6 9
