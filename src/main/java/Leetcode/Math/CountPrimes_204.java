package Leetcode.Math;

import java.util.Arrays;

public class CountPrimes_204 {
    public int countPrimes(int n) {
        // O(nlog(logn)) - 10ms
        boolean[] nums = new boolean[n+1];
        Arrays.fill(nums, true);
        for (int i=2; i*i<n; i++){
            if (!nums[i])
                continue;
            for (int j=i*i; j<n; j+=i)
                nums[j] = false;
        }
        int res = 0;
        for (int i=2; i<n; i++){
            if (nums[i])
                res++;
        }
        return res;

        // 12ms
//        boolean[] notPrime = new boolean[n+1];
//        int res = 0;
//        for (int i=2; i<n; i++){
//            if (notPrime[i])
//                continue;
//            res++;
//            for (int j=2; i*j<n; j++)
//                notPrime[i*j] = true;
//        }
//        return res;
    }
}
