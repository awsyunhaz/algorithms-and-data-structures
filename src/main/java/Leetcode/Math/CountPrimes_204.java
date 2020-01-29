package Leetcode.Math;

import java.util.Arrays;

public class CountPrimes_204 {
//    public int countPrimes(int n) {
//        boolean[] notPrime = new boolean[n];
//        int sum = 0;
//        for (int i = 2; i < n; i++) {
//            if (!notPrime[i]) {
//                sum ++;
//                for (int j = 2; i*j < n; j++) {
//                    notPrime[i*j] = true;
//                }
//            }
//        }
//        return sum;
//    }

    // Optimization, O(nlog(logn))
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            // start from i^2
            for (int j = i*i; j < n; j+=i) {
                notPrime[j] = true;
            }
        }
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                sum ++;
            }
        }
        return sum;
    }
}
