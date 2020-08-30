package Leetcode.DynamicProgramming;

import java.util.Arrays;

public class CoinChange_322 {
    // recursion with memorization
//    public int coinChange(int[] coins, int amount) {
//        int[] memory = new int[amount+1];
//        int res = change(coins, amount, memory);
//        return res == Integer.MAX_VALUE? -1: res;
//    }
//
//    public int change(int[] coins, int amount, int[] memory) {
//        if (amount == 0) {
//            return 0;
//        }
//        if (memory[amount] > 0) {
//            return memory[amount];
//        }
//        int min = Integer.MAX_VALUE;
//        for (int coin: coins) {
//            if (coin <= amount) {
//                memory[amount - coin] = change(coins, amount - coin, memory);
//                min = Math.min(min, memory[amount-coin]);
//            }
//        }
//        memory[amount] = min == Integer.MAX_VALUE? Integer.MAX_VALUE: min + 1;
//        return memory[amount];
//    }

    // DP
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

    // DP, O(kn)
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
