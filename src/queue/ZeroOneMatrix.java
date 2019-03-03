package queue;

import java.util.*;

public class ZeroOneMatrix {
//    public int[][] updateMatrix(int[][] matrix) {
//        for(int i = 0; i < matrix.length; i++) {
//            for(int j = 0; j < matrix[0].length; j++) {
//                if(matrix[i][j] == 1)
//                    matrix[i][j] = findMinNeighbour(matrix, i, j);
//            }
//        }
//        return matrix;
//    }
//
//    public int findMinNeighbour(int[][] matrix, int i, int j) {
//        List<Integer> list = new ArrayList<>();
//        if(i - 1 >= 0)
//            list.add(matrix[i - 1][j]);
//        if(i + 1 < matrix.length)
//            list.add(matrix[i + 1][j]);
//        if(j - 1 >= 0)
//            list.add(matrix[i][j - 1]);
//        if(j + 1 < matrix[0].length)
//            list.add(matrix[i][j + 1]);
//        int min = list.get(0);
//        for(int k = 1; k < list.size(); k++)
//            if(list.get(k) < min)
//                min = list.get(k);
//        return min + 1;
//    }

//    public int[][] updateMatrix(int[][] matrix) {
//        int[][] visited = new int[matrix.length][matrix[0].length];
//        for(int i = 0; i < matrix.length; i++) {
//            for(int j = 0; j < matrix[0].length; j++) {
//                if(matrix[i][j] == 1 && visited[i][j] == 0)
//                    DFS(matrix, visited, i, j);
//            }
//        }
//        return matrix;
//    }
//
//    public int DFS(int[][] matrix, int[][] visited, int i, int j) {
//        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
//            return Integer.MAX_VALUE;
//        if(visited[i][j] == 1)
//            return matrix[i][j];
//        visited[i][j] = 1;
//        if(matrix[i][j] == 1)
//            matrix[i][j] = findFourMin(DFS(matrix, visited, i, j + 1),
//                    DFS(matrix, visited, i, j - 1),
//                    DFS(matrix, visited, i - 1, j),
//                    DFS(matrix, visited, i + 1, j)) + 1;
//        return matrix[i][j];
//    }
//
//    public int findFourMin(int a, int b, int c, int d) {
//        if(a < b)
//            b = a;
//        if(c < d)
//            d = c;
//        if(b < d)
//            return b;
//        else
//            return d;
//    }

//    [1, 0, 1, 1, 0, 0, 1, 0, 0, 1]
//    [0, 1, 1, 0, 1, 0, 1, 0, 1, 1]
//    [0, 0, 1, 0, 1, 0, 0, 1, 0, 0]
//    [1, 0, 1, 0, 1, 1, 1, 1, 1, 1]
//    [0, 1, 0, 1, 1, 0, 0, 0, 0, 1]
//    [0, 0, 1, 0, 1, 1, 1, 0, 1, 0]
//    [0, 1, 0, 1, 0, 1, 0, 0, 1, 1]
//    [1, 0, 0, 0, 1, 1, 1, 1, 0, 1]
//    [1, 1, 1, 1, 1, 1, 1, 0, 1, 0]
//    [1, 1, 1, 1, 0, 1, 0, 0, 1, 1]

    public static class Coordinates {
        int i;
        int j;
        Coordinates(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public boolean equals(Object o) {
            if(o == null || o.getClass() != this.getClass())
                return false;
            Coordinates cords = (Coordinates)o;
            if(this.i == cords.i && this.j == cords.j)
                return true;
            return false;
        }
    }

    public static void main(String[] args) {
        ZeroOneMatrix obj = new ZeroOneMatrix();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        matrix = obj.updateMatrix(matrix);
        for(int x[] : matrix) {
            for(int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1)
                    matrix[i][j] = BFS(matrix, i, j);
            }
        }
        return matrix;
    }

    public int BFS(int[][] matrix, int i, int j) {
        Queue<Coordinates> q = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        q.add(new Coordinates(i, j));
        visited.add(new Coordinates(i, j));
        int step = -1;
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            for(; size > 0; size--) {
                Coordinates cords = q.poll();
                if(matrix[cords.i][cords.j] == 0)
                    return step;

                if(cords.j + 1 < matrix[0].length && !visited.contains(new Coordinates(cords.i, cords.j + 1))) {
                    q.add(new Coordinates(cords.i, cords.j + 1));
                    visited.add(new Coordinates(cords.i, cords.j + 1));
                }
                if(cords.j - 1 >= 0 && !visited.contains(new Coordinates(cords.i, cords.j - 1))) {
                    q.add(new Coordinates(cords.i, cords.j - 1));
                    visited.add(new Coordinates(cords.i, cords.j - 1));
                }
                if(cords.i + 1 < matrix.length && !visited.contains(new Coordinates(cords.i + 1, cords.j))) {
                    q.add(new Coordinates(cords.i + 1, cords.j));
                    visited.add(new Coordinates(cords.i + 1, cords.j));
                }
                if(cords.i - 1 >= 0 && !visited.contains(new Coordinates(cords.i - 1, cords.j))) {
                    q.add(new Coordinates(cords.i - 1, cords.j));
                    visited.add(new Coordinates(cords.i - 1, cords.j));
                }
            }
        }
        return 1;
    }
}
