package graphs;

import java.io.IOException;
import java.util.*;

public class JourneyToTheMoon {
    static long journeyToMoon(int n, int[][] astronaut) {
        adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            adjList.add(new HashSet<>());
        for(int i = 0; i < astronaut.length; i++) {
            adjList.get(astronaut[i][0]).add(astronaut[i][1]);
            adjList.get(astronaut[i][1]).add(astronaut[i][0]);
        }

        visited = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            visited.add(false);
        comp = new ArrayList<>();

        dfs(0);
        List<Integer> comps = findComps(n);

        int result = 0;
        int predSum = 0;
        for(int i = 0; i < comps.size() - 1; i++) {
            result += (predSum + comps.get(i)) * comps.get(i + 1);
            predSum += comps.get(i);
        }
        return result;
    }

    static List<Set<Integer>> adjList;
    static List<Boolean> visited;
    static List<Integer> comp;

    static void dfs(int v) {
        visited.set(v, true);
        comp.add(v);

        for(int x : adjList.get(v)) {
            if(!visited.get(x))
                dfs(x);
        }
    }

    static List<Integer> findComps(int n) {
        List<Integer> comps = new ArrayList<>();
        for(int i = 0; i < n; i++)
            visited.set(i, false);

        for(int i = 0; i < n; i++) {
            if(!visited.get(i)) {
                comp.clear();
                dfs(i);
            }
        }
        System.out.println();
        comps.add(comp.size());
        return comps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);
        System.out.println(result);
        scanner.close();
    }
}
