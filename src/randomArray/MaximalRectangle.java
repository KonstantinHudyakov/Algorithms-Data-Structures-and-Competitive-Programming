package randomArray;

public class MaximalRectangle {
    public static void main(String[] args) {

    }

    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(Character.getNumericValue(matrix[i][j]) == 1) {
                    int start = j;
                    while(j + 1 < matrix[0].length && Character.getNumericValue(matrix[i][j + 1]) != 0)
                        j++;
                    for(int a = start; a <= j; a++) {
                        int sum = a - start + 1;

                        boolean flag = true;
                        int line = i + 1;
                        while (flag && line < matrix.length) {
                            for (int k = start; k <= a && flag; k++) {
                                if (Character.getNumericValue(matrix[line][k]) != 1)
                                    flag = false;
                            }
                            if (flag)
                                sum += a - start + 1;
                            line++;
                        }

                        line = i - 1;
                        flag = true;
                        while (flag && line >= 0) {
                            for (int k = start; k <= a && flag; k++) {
                                if (Character.getNumericValue(matrix[line][k]) != 1)
                                    flag = false;
                            }
                            if (flag)
                                sum += a - start + 1;
                            line--;
                        }

                        if (sum > res)
                            res = sum;
                    }
                }
            }
        }
        return res;
    }
}
