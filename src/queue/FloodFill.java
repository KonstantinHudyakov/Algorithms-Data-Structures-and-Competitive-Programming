package queue;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        FloodFill obj = new FloodFill();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        image = obj.floodFill(image, 1, 1, 2);
        for(int[] x : image) {
            for(int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }

    public static class Coordinates {
        int i;
        int j;
        Coordinates(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        Queue<Coordinates> q = new LinkedList<>();
        q.add(new Coordinates(sr, sc));
        int old = image[sr][sc];
        image[sr][sc] = newColor;
        while(!q.isEmpty()) {
            int size = q.size();
            for(; size > 0; size--) {
                Coordinates cords = q.poll();
                if(cords.i - 1 >= 0 && image[cords.i - 1][cords.j] == old) {
                    image[cords.i - 1][cords.j] = newColor;
                    q.add(new Coordinates(cords.i - 1, cords.j));
                }
                if(cords.i + 1 < image.length && image[cords.i + 1][cords.j] == old) {
                    image[cords.i + 1][cords.j] = newColor;
                    q.add(new Coordinates(cords.i + 1, cords.j));
                }
                if(cords.j - 1 >= 0 && image[cords.i][cords.j - 1] == old) {
                    image[cords.i][cords.j - 1] = newColor;
                    q.add(new Coordinates(cords.i, cords.j - 1));
                }
                if(cords.j + 1 < image[0].length && image[cords.i][cords.j + 1] == old) {
                    image[cords.i][cords.j + 1] = newColor;
                    q.add(new Coordinates(cords.i, cords.j + 1));
                }
            }
        }
        return image;
    }
}
// 1 1 1
// 1 1 0
// 1 0 1