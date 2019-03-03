package randomArray;

public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix obj = new Search2DMatrix();
        int[][] matrix = {{1}};
        boolean res = obj.searchMatrix(matrix, 1);
        System.out.println(res);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        boolean res = false;
        int line = findLine(matrix, target);
        if(line >= 0) {
            int i = 0, j = matrix[line].length - 1;
            while (i <= j && !res) {
                if (matrix[line][i] == target || matrix[line][j] == target)
                    res = true;
                i++;
                j--;
            }
        }
        return res;
    }

    public int findLine(int[][] matrix, int target) {
        int line = -1;
        for(int i = 0; i < matrix.length && line == -1; i++) {
            if(target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1])
                line = i;
        }
        return line;
    }
}
