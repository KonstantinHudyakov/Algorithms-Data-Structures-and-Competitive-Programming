package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindClosestElements {
    public static void main(String[] args) {
        FindClosestElements obj = new FindClosestElements();
        int[] arr = {0, 1, 2, 4, 6, 7, 8};
        List<Integer> res = obj.findClosestElements(arr, 4, 5);
        System.out.println(res);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0)
            return null;
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < x)
                left = mid + 1;
            else
                right = mid;
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        if(arr[left] == x) {
            result.add(x);
            i++;
        }
        else right--;
        for(; i < k; i++) {
            if(left - 1 >= 0 && right + 1 < arr.length) {
                if(x - arr[left - 1] <= arr[right + 1] - x) {
                    result.add(arr[left - 1]);
                    left--;
                }
                else {
                    result.add(arr[right + 1]);
                    right++;
                }
            }
            else if(left - 1 >= 0) {
                result.add(arr[left - 1]);
                left--;
            }
            else if(right + 1 < arr.length){
                result.add(arr[right + 1]);
                right++;
            }
        }
        result.sort(Comparator.comparingInt((a) -> {return a;}));
        return result;
    }
}