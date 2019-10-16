package Leetcode.DynamicProgramming;

// One pass - O(N)
public class BestTimetoBuyandSellStock_121 {
    public int maxProfit(int[] prices) {
        int loPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int price: prices) {
            loPrice = Math.min(loPrice, price);
            profit = Math.max(price - loPrice, profit);
        }
        return profit;
    }
}
