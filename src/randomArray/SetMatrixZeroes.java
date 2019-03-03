package randomArray;

import java.util.ArrayList;

public class SetMatrixZeroes {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0)
                    list.add(new Pair(i, j));
            }
        }

        for (Pair pair : list) {
            lineSetZero(matrix, pair.i);
            colSetZero(matrix, pair.j);
        }
    }

    public void lineSetZero(int[][] matrix, int line) {
        for(int i = 0; i < matrix[line].length; i++)
            matrix[line][i] = 0;
    }

    public void colSetZero(int[][] matrix, int col) {
        for(int i = 0; i < matrix.length; i++)
            matrix[i][col] = 0;
    }

    static class Pair {
        public int i;
        public int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
