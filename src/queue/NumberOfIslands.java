package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        int num = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(goThroughIsland(grid, i, j)) {
                    num++;
                }
            }
        }
        return num;
    }

    public boolean goThroughIsland(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return false;
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
            goThroughIsland(grid, i, j + 1);
            goThroughIsland(grid, i, j - 1);
            goThroughIsland(grid,i + 1, j);
            goThroughIsland(grid,i - 1, j);
            return true;
        }
        return false;
    }
}