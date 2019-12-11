package Leetcode.TwoPointers;

import java.util.Arrays;
import java.util.TreeSet;

public class TwoSumLessThanK_1099 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int lo = 0, hi = A.length-1;
        int dis = Integer.MAX_VALUE;
        while (lo < hi) {
            if (A[lo] + A[hi] < K) {
                dis = Math.min(dis, K - A[lo] - A[hi]);
                lo ++;
            }
            else {
                hi --;
            }
        }
        return dis == Integer.MAX_VALUE? -1: K-dis;
    }

    // Treeset - O(nlogn)
//    public int twoSumLessThanK(int[] A, int K) {
//        TreeSet<Integer> tree = new TreeSet<>();
//        int res = Integer.MAX_VALUE;
//        for (int a: A) {
//            Integer b = tree.lower(K - a);
//            if (b != null && K - a - b < res)
//                res = K - a - b;
//            tree.add(a);
//        }
//        return res == Integer.MAX_VALUE? -1: K - res;
//    }
}
