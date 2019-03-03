package hashTable;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums) {
            if(set.contains(x))
                set.remove(x);
            else
                set.add(x);
        }
        return set.iterator().next();
    }
}
