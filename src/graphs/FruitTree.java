package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class FruitTree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = reader.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        fr = new int[n + 1];
        String[] fruits = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            fr[i] = Integer.parseInt(fruits[i - 1]);

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        String[] line;
        int a, b;
        depth = new int[n + 1];
        edges = new int[n + 1];
//        int[] next = new int[n - 1];
//        int[] prev = new int[n - 1];
//        int[] a_ = new int[n - 1];
//        int[] b_ = new int[n - 1];

        for(int i = 0; i < n - 1; i++) {
            line = reader.readLine().split(" ");
            a = Integer.parseInt(line[0]);
            b = Integer.parseInt(line[1]);
//            next[i] = i + 1;
//            prev[i] = i - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
//        next[n - 2] = 0;
//        prev[0] = n - 2;
//        int j = (int)(Math.random() % (n - 1));
//        edges[a_[j]] = -1;
//        depth[a_[j]] = 0;
//        while (next[j] != j) {
//            if(edges[a_[j]] != 0) {
//                edges[b_[j]] = a_[j];
//                depth[b_[j]] = depth[a_[j]] + 1;
//                next[prev[j]] = next[j];
//                prev[next[j]] = prev[j];
//            }
//            else if(edges[b_[j]] != 0) {
//                edges[a_[j]] = b_[j];
//                depth[a_[j]] = depth[b_[j]] + 1;
//                next[prev[j]] = next[j];
//                prev[next[j]] = prev[j];
//            }
//            j = next[j];
//        }
//        if(edges[a_[j]] != 0) {
//            edges[b_[j]] = a_[j];
//            depth[b_[j]] = depth[a_[j]] + 1;
//        }
//        else if(edges[b_[j]] != 0) {
//            edges[a_[j]] = b_[j];
//            depth[a_[j]] = depth[b_[j]] + 1;
//        }

        edges[1] = -1;
        depth[1] = 0;
        add(edges, depth, 1, adj);

//        List<int[]> skiped = new ArrayList<>();
//
//        line = reader.readLine().split(" ");
//        //int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]);
//        edges[a] = b;
//        edges[b] = -1;
//        depth[b] = 0;
//        depth[a] = 1;
//
//        for(int i = 0; i < n - 2; i++) {
//            line = reader.readLine().split(" ");
//            a = Integer.parseInt(line[0]);
//            b = Integer.parseInt(line[1]);
//            if(edges[a] != 0) {
//                edges[b] = a;
//                depth[b] = depth[a] + 1;
//            }
//            else if(edges[b] != 0) {
//                edges[a] = b;
//                depth[a] = depth[b] + 1;
//            }
//            else
//                skiped.add(new int[] {a, b});
//        }
//
//        List<Integer> sk = new ArrayList<>();
//        for(int i = 0; i < skiped.size(); i++)
//            sk.add(i);
//
//        while(!sk.isEmpty()) {
//            List<Integer> newSk = new ArrayList<>();
//            for (int i : sk) {
//                a = skiped.get(i)[0];
//                b = skiped.get(i)[1];
//                if (edges[a] != 0) {
//                    edges[b] = a;
//                    depth[b] = depth[a] + 1;
//                } else if (edges[b] != 0) {
//                    edges[a] = b;
//                    depth[a] = depth[b] + 1;
//                } else
//                    newSk.add(i);
//            }
//            sk = newSk;
//        }

        queryQueue = new ArrayBlockingQueue<>(100);
        queryAnswers = new int[q];
        isAllQueriesRead = new AtomicBoolean(false);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> results = new ArrayList<>();
        List<Callable<Integer>> queries = new ArrayList<>();

        for(int i = 0; i < q; i++) {
            line = reader.readLine().split(" ");
            queries.add(new QueryExecutor(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            //System.out.println(executeQuery(edges, depth, fr, a, b));
        }

//        isAllQueriesRead.set(true);
//        for(Thread thread : threadList) {
//            try {
//                thread.join();
//            }
//            catch (InterruptedException e) {}
//        }
        try {
            results = executor.invokeAll(queries);
        }
        catch (InterruptedException e) {}

        for(Future<Integer> ans : results) {
            try {
                System.out.println(ans.get());
            }
            catch (Exception e) {}
        }
        executor.shutdown();
    }

    public static AtomicBoolean isAllQueriesRead;
    public static ArrayBlockingQueue<int[]> queryQueue;
    public static int[] queryAnswers;
    public static int[] edges;
    public static int[] depth;
    public static int[] fr;

    public static class QueryExecutor implements Callable<Integer>{
        public int a;
        public int b;

        public QueryExecutor(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public Integer call() {
//            int[] query = null;
//            while(!queryQueue.isEmpty() || !isAllQueriesRead.get()) {
//                //System.out.println(queryQueue.isEmpty() + " " + isAllQueriesRead.get());
//                try {
//                    if(queryQueue.isEmpty()) {
//                        sleep(5);
//                        continue;
//                    }
//                    query = queryQueue.take();
//                }
//                catch (InterruptedException e) {}
//                int a = query[1];
//                int b = query[2];
                int depthA = depth[a];
                int depthB = depth[b];
                int max = 0;
                int cnt = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 0);

                while(depthA < depthB) {
                    map.put(fr[b], 1 + map.getOrDefault(fr[b], 0));
                    if(map.get(max) < map.get(fr[b]))
                        max = fr[b];
                    cnt++;
                    b = edges[b];
                    depthB--;
                }

                while(depthB < depthA) {
                    map.put(fr[a], 1 + map.getOrDefault(fr[a], 0));
                    if(map.get(max) < map.get(fr[a]))
                        max = fr[a];
                    cnt++;
                    a = edges[a];
                    depthA--;
                }
                while(a != b) {
                    map.put(fr[b], 1 + map.getOrDefault(fr[b], 0));
                    map.put(fr[a], 1 + map.getOrDefault(fr[a], 0));
                    if(map.get(max) < map.get(fr[a]))
                        max = fr[a];
                    if(map.get(max) < map.get(fr[b]))
                        max = fr[b];
                    cnt += 2;
                    a = edges[a];
                    b = edges[b];
                }
                map.put(fr[b], 1 + map.getOrDefault(fr[b], 0));
                cnt++;
                if(map.get(max) < map.get(fr[b]))
                    max = fr[b];
                if(map.get(max) > cnt / 2)
                    return max;
                else
                    return -1;
        }
    }

    public static int executeQuery(int[] edges, int[] depth, int[] fr, int a, int b) {
        int depthA = depth[a];
        int depthB = depth[b];
        int max = 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        while(depthA < depthB) {
            map.put(fr[b], 1 + map.getOrDefault(fr[b], 0));
            if(map.get(max) < map.get(fr[b]))
                max = fr[b];
            cnt++;
            b = edges[b];
            depthB--;
        }

        while(depthB < depthA) {
            map.put(fr[a], 1 + map.getOrDefault(fr[a], 0));
            if(map.get(max) < map.get(fr[a]))
                max = fr[a];
            cnt++;
            a = edges[a];
            depthA--;
        }
        while(a != b) {
            map.put(fr[b], 1 + map.getOrDefault(fr[b], 0));
            map.put(fr[a], 1 + map.getOrDefault(fr[a], 0));
            if(map.get(max) < map.get(fr[a]))
                max = fr[a];
            if(map.get(max) < map.get(fr[b]))
                max = fr[b];
            cnt += 2;
            a = edges[a];
            b = edges[b];
        }
        map.put(fr[b], 1 + map.getOrDefault(fr[b], 0));
        cnt++;
        if(map.get(max) < map.get(fr[b]))
            max = fr[b];
        if(map.get(max) > cnt / 2)
            return max;
        else
            return -1;
    }

    public static void add(int[] edges, int[] depth, int curRoot, List<List<Integer>> adj) {
        for(int x : adj.get(curRoot)) {
            if(edges[x] == 0) {
                edges[x] = curRoot;
                depth[x] = depth[curRoot] + 1;
                add(edges, depth, x, adj);
            }
        }
    }
}
