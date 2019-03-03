package graphs;

import java.io.*;
import java.util.*;

public class ShortestPath {
    // Complete the shortestReach function below.
    static int[] shortestReach(int n, int[][] edges, int s) {
        List<Map<Integer, Integer>> list = new ArrayList<>(n);
        for(int i = 0; i <= n; i++)
            list.add(new HashMap<>());
        for(int i = 0; i < edges.length; i++) {
            addToMap(list, edges[i][0], edges[i][1], edges[i][2]);
            addToMap(list, edges[i][1], edges[i][0], edges[i][2]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        Set<Integer> visited = new HashSet<>();
        while(visited.size() < n) {
            int node = findMinInArray(dist, visited);
            visited.add(node);
            if(list.get(node).isEmpty())
                continue;
            for(Map.Entry<Integer, Integer> pair : list.get(node).entrySet()) {
                dist[pair.getKey()] = (int)Math.min(dist[pair.getKey()], (long)dist[node] + pair.getValue());
            }
        }
        for(int i = 1; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }

        int[] res = new int[n - 1];
        for(int i = 1; i < s; i++)
            res[i - 1] = dist[i];
        for(int i = s + 1; i < n + 1; i++)
            res[i - 2] = dist[i];
        return res;
    }

    private static void addToMap(List<Map<Integer, Integer>> list, int from, int to, int weight) {
        Map<Integer, Integer> neighbors = list.get(from);
        neighbors.put(to, Math.min(weight, neighbors.getOrDefault(to, Integer.MAX_VALUE)));
    }

    private static int findMinInArray(int[] arr, Set<Integer> visited) {
        int min = -1;
        for(int i = 0; i < arr.length; i++) {
            if(!visited.contains(i)) {
                min = i;
                break;
            }
        }
        for(int i = min + 1; i < arr.length; i++) {
            if(arr[i] < arr[min] && !visited.contains(i))
                min = i;
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));//(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = reader.readLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][3];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = reader.readLine().split(" ");
              //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(edgesRowItems[j]);
            }

            int s = Integer.parseInt(reader.readLine());
         //   scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = shortestReach(n, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        reader.close();
    }
}
