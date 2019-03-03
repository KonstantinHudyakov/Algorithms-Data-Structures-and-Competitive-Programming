package arrayAndString;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        int res = obj.uniquePaths(15, 20);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0)
                    map[i][j] = 1;
                else
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[n - 1][m - 1];
    }
}