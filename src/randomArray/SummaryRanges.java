package randomArray;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {

    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int start = i;
            while(i + 1 < nums.length && nums[i + 1] == nums[i] + 1)
                i++;
            String s = Integer.toString(nums[start]);
            if(i - start > 0)
                s += "->" + Integer.toString(nums[i]);
            list.add(s);
        }
        return list;
    }
}
