package randomArray;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum obj = new MinimumPathSum();
        int [][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = obj.recursion(grid, 0, 0);
        System.out.println(res);
    }

    public int minPathSum(int[][] grid) {
        return 1;
    }

    public int recursion(int[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length)
            return 0;
        return Math.min(recursion(grid, i + 1, j) + grid[i][j], recursion(grid, i, j + 1) + grid[i][j]);
    }
}
