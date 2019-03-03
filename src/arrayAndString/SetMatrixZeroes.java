package arrayAndString;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> lines = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    lines.add(i);
                    columns.add(j);
                }
            }
        }
        for(int x : lines)
            setLineZeroes(matrix, x);
        for(int x : columns)
            setColumnZeroes(matrix, x);
    }

    private void setLineZeroes(int[][] matrix, int lineIndex) {
        for(int i = 0; i < matrix[0].length; i++)
            matrix[lineIndex][i] = 0;
    }

    private void setColumnZeroes(int[][] matrix, int colIndex) {
        for(int i = 0; i < matrix.length; i++)
            matrix[i][colIndex] = 0;
    }
}
