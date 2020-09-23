package Leetcode.DynamicProgramming;

public class PaintHouse2_265 {
    // O(nk^2)
//    public int minCostII(int[][] costs) {
//        int n = costs.length;
//        if (n == 0)
//            return 0;
//        int k = costs[0].length;
//        int[][] f = new int[n][k];
//        f[0] = costs[0];
//        for (int i = 1; i < n; i++){
//            for (int j = 0; j < k; j++){
//                int minCost = Integer.MAX_VALUE;
//                for (int l = 1; l < k; l++) {
//                    minCost = Math.min(minCost, f[i-1][(j+l) % k]);
//                }
//                f[i][j] = minCost + costs[i][j];
//            }
//        }
//        int minCost = Integer.MAX_VALUE;
//        for (int j = 0; j < k; j++) {
//            minCost = Math.min(minCost, f[n-1][j]);
//        }
//        return minCost;
//    }

    // O(nk), keep the smallest and second smallest cost
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0)
            return 0;
        int k = costs[0].length;
        int[][] f = new int[n][k];
        int ind1 = -1, ind2 = -1;
        f[0] = costs[0];
        for (int i = 0; i < n; i++){
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int newInd1 = -1, newInd2 = -1;
            for (int j = 0; j < k; j++){
                if (i == 0) {
                    f[i][j] = costs[i][j];
                } else {
                    if (j == ind1) {
                        f[i][j] = f[i-1][ind2] + costs[i][j];
                    } else {
                        f[i][j] = f[i-1][ind1] + costs[i][j];
                    }
                }
                if (f[i][j] < min1) {
                    min2 = min1;
                    min1 = f[i][j];
                    newInd2 = newInd1;
                    newInd1 = j;
                } else if (f[i][j] < min2) {
                    min2 = f[i][j];
                    newInd2 = j;
                }
            }
            ind1 = newInd1;
            ind2 = newInd2;
        }
        return f[n-1][ind1];
    }
}
