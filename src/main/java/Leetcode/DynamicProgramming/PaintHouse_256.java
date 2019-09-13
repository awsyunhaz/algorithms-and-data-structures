package Leetcode.DynamicProgramming;

public class PaintHouse_256 {

//    DFS - TLE
//    private int min = Integer.MAX_VALUE;
//
//    public int minCost(int[][] costs) {
//        int[] color = new int[costs.length];
//        search(costs, color, 0, 0);
//        return min;
//    }
//
//    public void search(int[][] costs, int[] color, int house, int cost){
//        if (house == costs.length){
//            min = Math.min(cost, min);
//            return;
//        }
//        for (int i = 0; i < 3; i++){
//            if (house > 0 && color[house - 1] == i)
//                continue;
//            color[house] = i;
//            search(costs, color, house+1, cost+costs[house][i]);
//        }
//    }

    // dp - O(n)
    public int minCost(int[][] costs) {
        int len = costs.length;
        if (len == 0)
            return 0;
        int[][] f = new int[len][3];
        f[0] = costs[0];
        for (int i = 1; i < len; i++){
            for (int j = 0; j < 3; j++){
                f[i][j] = Math.min(f[i-1][(j+1)%3], f[i-1][(j+2)%3]) + costs[i][j];
            }
        }
        return Math.min(Math.min(f[len-1][0], f[len-1][1]), f[len-1][2]);
    }

}
