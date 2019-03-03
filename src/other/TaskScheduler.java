package other;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler obj = new TaskScheduler();
        char[] tasks = new char[10000];
        Arrays.fill(tasks, 'A');
        int res = obj.leastInterval(tasks, 100);
        System.out.println(res);
    }

    //wrong
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b - a);

        int res = 0;
        while(!list.isEmpty()) {
            int deleted = 0;
            for(int i = 0; i <= n && !list.isEmpty(); ) {
                res++;
                if(i - deleted < list.size()) {
                    list.set(i - deleted, list.get(i - deleted) - 1);
                    if (list.get(i - deleted) == 0) {
                        list.remove(i - deleted);
                        deleted++;
                    }
                }
                i++;
            }
        }
        return res;
    }
}
