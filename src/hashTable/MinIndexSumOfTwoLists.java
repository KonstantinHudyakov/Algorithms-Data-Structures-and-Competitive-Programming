package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinIndexSumOfTwoLists {
    public static void main(String[] args) {

    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        int minSum = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int temp = map.get(list2[i]);
                if (temp + i < minSum) {
                    minSum = temp + i;
                    list.clear();
                    list.add(list2[i]);
                }
                else if(temp + i == minSum)
                    list.add(list2[i]);
            }
        }
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
