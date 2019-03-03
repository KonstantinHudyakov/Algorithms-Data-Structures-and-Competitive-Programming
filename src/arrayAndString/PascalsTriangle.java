package arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)
            return res;
        res.add(new ArrayList<>(Arrays.asList(1)));
        for(int i = 1; i < numRows; i++) {
            List<Integer> newLevel = new ArrayList<>();
            newLevel.add(1);
            List<Integer> prevLevel = res.get(i - 1);
            for(int j = 1; j < prevLevel.size(); j++)
                newLevel.add(prevLevel.get(j) + prevLevel.get(j - 1));
            newLevel.add(1);
            res.add(newLevel);
        }
        return res;
    }
}
