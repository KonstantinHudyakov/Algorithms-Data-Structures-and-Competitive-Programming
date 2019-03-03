package arrayAndString;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = -1;
        for(int i = 1; i < prices.length; i++) {
            if(buyPrice == -1 && prices[i - 1] < prices[i])
                buyPrice = prices[i - 1];
            else if(buyPrice != -1 && prices[i - 1] > prices[i]) {
                profit += prices[i - 1] - buyPrice;
                buyPrice = -1;
            }
        }
        if(buyPrice != -1 && prices[prices.length - 1] - buyPrice > 0)
            profit += prices[prices.length - 1] - buyPrice;
        return profit;
    }
}
