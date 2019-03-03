package arrayAndString;

public class DiagonalTraverse {
    public static void main(String[] args) {
        DiagonalTraverse obj = new DiagonalTraverse();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] res = obj.findDiagonalOrder(matrix);
        for(int x : res)
            System.out.print(x + " ");
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if(c == n - 1)
                    r++;
                else if(r == 0)
                    c++;
                else {
                    r--;
                    c++;
                }
            } else {
                if(r == m - 1)
                    c++;
                else if(c == 0)
                    r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return arr;
    }
}
// [ 1, 2, 3, 4],
// [ 4, 5, 6, 4],
// [ 7, 8, 9, 4],
// [ 9, 9, 9, 4]

//00
//01 10
//20 11 02
//03 12 21 30
//31 22 13
//23 32
//33