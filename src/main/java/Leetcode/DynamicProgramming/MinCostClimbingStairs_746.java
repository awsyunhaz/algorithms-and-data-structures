package Leetcode.DynamicProgramming;

public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length<2)
            Math.min(cost[0], cost[1]);
        int[] f = new int[cost.length+1];
        for (int i=2; i<=cost.length; i++){
            f[i] = Math.min(f[i-1] + cost[i-1], f[i-2] + cost[i-2]);
        }
        return f[cost.length];
    }

}
