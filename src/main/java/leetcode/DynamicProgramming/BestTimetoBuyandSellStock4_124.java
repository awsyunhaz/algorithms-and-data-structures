package leetcode.DynamicProgramming;

public class BestTimetoBuyandSellStock4_124 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length==0)
            return 0;
        if (k > prices.length/2){
            int profit = 0;
            for (int i = 0; i < prices.length-1; i++){
                if (prices[i] < prices[i+1])
                    profit += prices[i+1] - prices[i];
            }
            return profit;
        }

        int[][] f = new int[k+1][prices.length];
        for (int t = 1; t <= k; t++){
            int max = f[t-1][0] - prices[0];
            for (int i = 1; i < prices.length; i++){
                max = Math.max(max, f[t-1][i] - prices[i]);
                f[t][i] = Math.max(f[t][i-1], max + prices[i]);
            }
        }
        return f[k][prices.length-1];
    }
}
