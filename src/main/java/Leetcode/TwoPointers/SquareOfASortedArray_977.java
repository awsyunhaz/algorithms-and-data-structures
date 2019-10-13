package Leetcode.TwoPointers;

public class SquareOfASortedArray_977 {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int lo = 0, hi = n - 1, ind = n - 1;
        while (ind >= 0) {
            if (Math.abs(A[lo]) > Math.abs(A[hi])){
                res[ind--] = A[lo] * A[lo];
                lo ++;
            } else {
                res[ind--] = A[hi] * A[hi];
                hi --;
            }
        }
        return res;
    }
}
