package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for(int i = 0; i < t; i++) {
            String[] sizeAndK = reader.readLine().split(" ");
            int n = Integer.parseInt(sizeAndK[0]);
            int k = Integer.parseInt(sizeAndK[1]);
            String[] arrItems = reader.readLine().split(" ");
            int[] arr = new int[n];
            for(int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(arrItems[j]);
            System.out.println(unboundedKnapsack(k, arr));
        }
    }

    static int unboundedKnapsack(int k, int[] arr) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int max = 0;
        for(int x : arr) {
            if(!visited.contains(x) && x <= k) {
                if(x == k)
                    return x;
                visited.add(x);
                q.add(x);
                max = Math.max(max, x);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            max = Math.max(max, curr);
            if(max == k)
                return max;
            for(int x : arr) {
                if(!visited.contains(curr + x) && curr + x <= k) {
                    visited.add(curr + x);
                    q.add(curr + x);
                }
            }
        }
        return max;
    }
}
