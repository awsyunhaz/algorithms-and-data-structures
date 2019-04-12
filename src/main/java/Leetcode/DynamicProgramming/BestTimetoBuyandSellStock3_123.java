package Leetcode.DynamicProgramming;

// O(kn)
public class BestTimetoBuyandSellStock3_123 {
    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;
        int[][] f = new int[3][prices.length];
        for (int k = 1; k <= 2; k++){
            int max = f[k-1][0] - prices[0];
            for (int i = 1; i < prices.length; i++){
                //max：截止到i-1天的最高收益（拥有股票）
                //这里f[k-1][i-1]和f[k-1][i]效果一样
                //第i天买入（并卖出）收益为0
                max = Math.max(max, f[k-1][i-1] - prices[i]);
                f[k][i] = Math.max(f[k][i-1], max + prices[i]);
            }
        }
        return f[2][prices.length-1];
    }
}
