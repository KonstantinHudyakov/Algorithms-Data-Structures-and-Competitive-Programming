package stack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class GameOfTwoStacks {
    public static void main(String[] args) {

    }

    static int twoStacks(int x, int[] a, int[] b) {
        int i = 0;
        int sum = 0;
        while(i < a.length && sum + a[i] <= x) {
            sum += a[i];
            i++;
        }

        int max = i;
        int j = 0;
        while(j < b.length && i >= 0) {
            sum += b[j];
            j++;
            while(sum > x && i > 0) {
                i--;
                sum -= a[i];
            }
            if(sum <= x)
                max = Math.max(max, i + j);
        }
        return max;
    }
}
