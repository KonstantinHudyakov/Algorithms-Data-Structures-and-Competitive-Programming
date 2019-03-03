package arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public static void main(String[] args) {

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
        list.add(1);
        if(rowIndex == 0)
            return list;
        for(int i = 1; i <= rowIndex; i++) {
            int prev = list.get(0);
            for(int j = 1; j < i; j++) {
                int temp = list.get(j);
                list.set(j, prev + list.get(j));
                prev = temp;
            }
            list.add(1);
        }
        return list;
    }
}
