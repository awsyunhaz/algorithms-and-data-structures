package Leetcode.BinarySearch;

public class DivideTwoIntegers_29 {
    // solution using long
    public int divide(int dividend, int divisor) {
        // The only corner case that will cause overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if (dividend < 0 ^ divisor < 0) {
            sign = -1;
        }
        long dend = Math.abs((long) dividend);
        long dsor = Math.abs((long) divisor);
        return sign*help(dend, dsor);
    }

    public int help(long dividend, long divisor) {
        if (divisor > dividend) {
            return 0;
        }
        long dsor = divisor;
        int res = 1;
        while (dividend - dsor >= dsor) {
            dsor += dsor;
            res += res;
        }
        return res + help(dividend-dsor, divisor);
    }

    // Bit operation
//    public int divide(int dividend, int divisor) {
//        // The only corner case that will cause overflow
//        if (dividend == Integer.MIN_VALUE && divisor == -1) {
//            return Integer.MAX_VALUE;
//        }
//        int sign = dividend > 0 ^ divisor > 0? -1: 1;
//        int dend = Math.abs(dividend);
//        int dsor = Math.abs(divisor);
//        int res = 0;
//        // Can't be `dend >= dsor`
//        while (dend - dsor >= 0) {
//            int x = 0;
//            // Can't be `dsor << (x+1)`
//            while (dend - (dsor << 1 << x) >= 0) {
//                x++;
//            }
//            res += 1 << x;
//            dend -= dsor << x;
//        }
//        return res * sign;
//    }
}
