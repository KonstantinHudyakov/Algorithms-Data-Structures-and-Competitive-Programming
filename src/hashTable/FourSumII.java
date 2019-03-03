package hashTable;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = getMap(A, B);
        int res = 0;
        for(int x : C) {
            for(int y : D) {
                res += map.getOrDefault(-1 * (x + y), 0);
            }
        }
        return res;
    }

    private Map<Integer, Integer> getMap(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : a) {
            for(int y : b) {
                map.put(x + y, map.getOrDefault(x + y, 0) + 1);
            }
        }
        return map;
    }
}
