package other.round547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Game23 {

    public static int bfs(int n, int m) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.add(n);

        int step = -1;
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            for(; size > 0; size--) {
                int temp = q.poll();
                visited.add(temp);
                if (temp == m)
                    return step;
                int a = temp * 2;
                if(!visited.contains(a) && a <= m)
                    q.add(a);
                a = temp * 3;
                if(!visited.contains(a) && a <= m)
                    q.add(a);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        if(n == m) {
            System.out.println(0);
            return;
        }
        if(m % 2 != 0 && m % 3 != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(bfs(n, m));

    }
}
