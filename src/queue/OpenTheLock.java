package queue;

import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {
        OpenTheLock obj = new OpenTheLock();
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        int res = obj.openLock(deadends, "0202");
        System.out.println(res);
    }

    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        if(!visited.contains(start))
            q.add(start);
        else
            return -1;
        visited.add(start);
        int step = - 1;
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String temp = q.poll();
                if (temp.equals(target))
                    return step;
                for(int j = 0; j < 4; j++) {
                    int num = Character.getNumericValue(temp.charAt(j));
                    if(num == 0)
                        num = 10;
                    String s = temp.substring(0, j)
                            + Character.forDigit((num + 1) % 10, 10)
                            + temp.substring(j + 1);
                    if(!visited.contains(s)) {
                        q.add(s);
                        visited.add(s);
                    }
                    s = temp.substring(0, j)
                            + Character.forDigit((num - 1) % 10, 10)
                            + temp.substring(j + 1);
                    if(!visited.contains(s)) {
                        q.add(s);
                        visited.add(s);
                    }
                }
            }
        }
        return -1;
    }

//    public boolean isDeadEnd(String[] deadends, String s) {
//        boolean flag = false;
//        for(int i = 0; i < deadends.length && !flag; i++) {
//            if(s.equals(deadends[i]))
//                flag = true;
//        }
//        return flag;
//    }
}
