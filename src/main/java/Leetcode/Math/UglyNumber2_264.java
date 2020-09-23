package Leetcode.Math;

import java.util.HashSet;

public class UglyNumber2_264 {
    // TLE
//    public int nthUglyNumber(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        HashSet<Integer> uglyNumbers = new HashSet<>();
//        uglyNumbers.add(1);
//        int num = 1, count = 1;
//        while (count < n) {
//            num ++;
//            if (num % 2 == 0 && uglyNumbers.contains(num/2) || num % 3 == 0 && uglyNumbers.contains(num/3) || num % 5 == 0 && uglyNumbers.contains(num/5)) {
//                uglyNumbers.add(num);
//                count ++;
//            }
//        }
//        return num;
//    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int ind2 = 0, ind3 = 0, ind5 = 0;
        for (int i = 1; i < n; i++) {
            int num = Math.min(Math.min(dp[ind2]*2, dp[ind3]*3), dp[ind5]*5);
            dp[i] = num;
            if (num == dp[ind2]*2) ind2++;
            if (num == dp[ind3]*3) ind3++;
            if (num == dp[ind5]*5) ind5++;
        }
        return dp[n-1];
    }
}
