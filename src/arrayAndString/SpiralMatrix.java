package arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = obj.spiralOrder(matrix);
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while(up <= down && left <= right) {
            for (int i = left; i <= right; i++)
                result.add(matrix[up][i]);
            up++;

            for (int i = up; i <= down; i++)
                result.add(matrix[i][right]);
            right--;

            if(up <= down) {
                for (int i = right; i >= left; i--)
                    result.add(matrix[down][i]);
            }
            down--;

            if(left <= right) {
                for (int i = down; i >= up; i--)
                    result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
