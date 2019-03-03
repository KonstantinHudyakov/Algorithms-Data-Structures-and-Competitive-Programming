package randomArray;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle obj = new Triangle();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> line1 = new ArrayList<>();
        line1.add(2);

        List<Integer> line2 = new ArrayList<>();
        line2.add(3);
        line2.add(4);

        List<Integer> line3 = new ArrayList<>();
        line3.add(6);
        line3.add(5);
        line3.add(9);

        List<Integer> line4 = new ArrayList<>();
        line4.add(4);
        line4.add(4);
        line4.add(8);
        line4.add(0);

        list.add(line1);
        list.add(line2);
        list.add(line3);
        list.add(line4);

        int min = obj.minimumTotal(list);
        System.out.println(min);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.get(triangle.size() - 1).size();
        int[] last = new int[size];
        for(int i = 0; i < size; i++)
            last[i] = triangle.get(triangle.size() - 1).get(i);

        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                last[j] = Math.min(last[j], last[j + 1]) + triangle.get(i).get(j);
            }
        }
        return last[0];
    }

    public int rec(List<List<Integer>> triangle, int i, int j) {
        if(i == triangle.size() - 1)
            return triangle.get(i).get(j);
        int minLeft = rec(triangle, i + 1, j);
        int minRight = rec(triangle, i + 1, j + 1);
        return Math.min(minLeft, minRight) + triangle.get(i).get(j);
    }
}