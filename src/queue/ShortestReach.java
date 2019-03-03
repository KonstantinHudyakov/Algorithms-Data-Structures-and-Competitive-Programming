package queue;

import java.io.*;
import java.util.*;

public class ShortestReach {
    static int[] bfs(int n, int m, List<Set<Integer>> edges, int s) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        result[s] = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int x : edges.get(curr)) {
                if(result[x] == -1) {
                    q.add(x);
                    result[x] = result[curr] + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine());
        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = reader.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            List<Set<Integer>> edges = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                edges.add(new HashSet<>());
            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = reader.readLine().split(" ");
                int vertex1 = Integer.parseInt(edgesRowItems[0]);
                int vertex2 = Integer.parseInt(edgesRowItems[1]);
                edges.get(vertex1).add(vertex2);
                edges.get(vertex2).add(vertex1);
            }

            int s = Integer.parseInt(reader.readLine());
            int[] result = bfs(n, m, edges, s);
            for (int i = 1; i < result.length; i++) {
                if(i == s)
                    continue;
                if(result[i] == -1)
                    System.out.print(result[i] + " ");
                else
                    System.out.print(result[i] * 6 + " ");
            }
            System.out.println();
        }
        reader.close();
    }
}
