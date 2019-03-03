package dynamicProgramming;

import java.util.Map;
import java.util.TreeMap;

public class BestTimeToBusAndSellStock {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++)
                profit = Math.max(profit, prices[j] - prices[i]);
        }
        return profit;
    }
}
