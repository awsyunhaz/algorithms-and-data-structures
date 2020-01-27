package Leetcode.DynamicProgramming;

import java.util.Arrays;

public class CoinChange_322 {

//    public int coinChange(int[] coins, int amount) {
//        int[] res = new int[amount+1];
//        Arrays.fill(res, -1);
//        res[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int c: coins) {
//                if (i - c >= 0 && res[i-c] >= 0) {
//                    if (res[i] == -1) {
//                        res[i] = res[i-c] + 1;
//                    } else {
//                        res[i] = Math.min(res[i], res[i-c] + 1);
//                    }
//                }
//            }
//        }
//        return res[amount];
//    }

    // O(kn)
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        // Initialize state to maximum
        Arrays.fill(res, amount+1);
        res[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c: coins) {
                if (i - c >= 0) {
                    res[i] = Math.min(res[i], res[i-c] + 1);
                }
            }
        }
        return res[amount] == amount+1? -1: res[amount];
    }
}
