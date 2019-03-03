package queue;

import java.util.*;

public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares obj = new PerfectSquares();
        int res = obj.numSquares(7168);
        System.out.println(res);
    }

    public int numSquares(int n) {
        if(n <= 0)
            return 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int max = 1;
        while(max * max <= n)
            max++;
        max--;
        for(; max > 0; max--) {
            q.add(max * max);
            visited.add(max * max);
        }
        int step = 0;
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            for(; size > 0; size--) {
                int sum = q.poll();
                if(sum == n)
                    return step;
                List<Integer> list = getAddition(n, sum);
                for(int i = list.size() - 1; i >= 0; i--) {
                    int newSum = sum + list.get(i) * list.get(i);
                    if(!visited.contains(newSum)) {
                        q.add(newSum);
                        visited.add(newSum);
                    }
                }
            }
        }
        return 1;
    }

    List<Integer> getAddition(int n, int sum) {
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        list.add(1);
        for(int i = 2; !flag; i++) {
            if(sum + i * i <= n)
                    list.add(i);
            else
                flag = true;
        }
        return list;
    }
}
