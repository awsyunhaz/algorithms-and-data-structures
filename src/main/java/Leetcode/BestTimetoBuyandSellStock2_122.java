package Leetcode;

public class BestTimetoBuyandSellStock2_122 {
    public int maxProfit(int[] prices) {
//        int profit = 0;
//        for (int i = 0; i < prices.length-1; i++){
//            if (prices[i] < prices[i+1])
//                profit += prices[i+1] - prices[i];
//        }
//        return profit;

        // DP solution
        if (prices.length==0)
            return 0;
        int[] f = new int[prices.length];
        f[0] = 0;
        int max = f[0] - prices[0];
        for (int i = 1; i < prices.length; i++){
            //截止到i-1天的最高收益（拥有股票）：选择最佳时机买入
            max = Math.max(f[i-1] - prices[i-1], max);
            //截止到i天的最高收益（不拥有股票）：选择最佳时机卖出
            f[i] = Math.max(f[i-1], max + prices[i]);
        }
        return f[prices.length-1];
    }

}
