package hashTable;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        return list.subList(0, k);
    }
}
