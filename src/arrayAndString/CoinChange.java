package arrayAndString;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CoinChange {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0)
            return -1;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        int step = -1;
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            for(; size > 0; size--) {
                int currAmount = q.poll();
                if(currAmount == amount)
                    return step;
                for(int x : coins) {
                    int newAmount = currAmount + x;
                    if(newAmount <= amount && !visited.contains(newAmount)) {
                        q.add(newAmount);
                        visited.add(newAmount);
                    }
                }
            }
        }
        return -1;
    }
}
