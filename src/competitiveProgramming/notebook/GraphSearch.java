package competitiveProgramming.notebook;

import java.util.*;

public class GraphSearch {

    public static int bfs(List<Set<Integer>> adj, int root, int target) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        q.add(root);
        int step = -1;

        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            for(; size > 0; size--) {
                int cur = q.poll();
                visited.add(cur);
                if(cur == target)
                    return step;

                for(int x : adj.get(cur)) {
                    if(!visited.contains(x))
                        q.add(x);
                }
            }
        }

        return -1;
    }




}
