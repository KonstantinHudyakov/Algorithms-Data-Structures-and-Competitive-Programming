package other.miptQuals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task3 {

    public static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b,a % b);
    }

    public static int bfs(List<HashSet<Integer>> edges, int u, int v, int[] parent) {
        if(u == v)
            return 0;
        int step = -1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(u);
        parent[u] = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            step++;
            for(;size > 0; size--) {
                int cur = q.poll();
                if(cur == v)
                    return step;
                for(int node : edges.get(cur)) {
                    if(parent[node] == 0) {
                        q.add(node);
                        parent[node] = cur;
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = reader.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);

        int[] nodes = new int[n + 1];

        String[] nodesItems = reader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int nodesItem = Integer.parseInt(nodesItems[i]);
            nodes[i + 1] = nodesItem;
        }

        List<HashSet<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            adj.add(new HashSet<>());

        for (int i = 0; i < n-1; i++) {
            String[] edgesRowItems = reader.readLine().split(" ");
            int h = Integer.parseInt(edgesRowItems[0]);
            int l = Integer.parseInt(edgesRowItems[1]);
            adj.get(h).add(l);
            adj.get(l).add(h);
        }

        for (int qItr = 0; qItr < q; qItr++) {
            String[] uv = reader.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            int[] parent = new int[n + 1];
            int way = bfs(adj, u, v, parent);

            if(way == 0) {
                System.out.println(0);
                continue;
            }

            ArrayList<Integer> wayNodes = new ArrayList<>();
            wayNodes.add(v);
            wayNodes.add(u);
            while(parent[v] != u) {
                wayNodes.add(parent[v]);
                v = parent[v];
            }

            int res = 0;
            for(int i = 0; i < wayNodes.size(); i++) {
                for(int j = i + 1; j < wayNodes.size(); j++) {
                    if(GCD(nodes[wayNodes.get(i)], nodes[wayNodes.get(j)]) == 1)
                        res++;
                }
            }
            System.out.println(res);
        }
    }
}
