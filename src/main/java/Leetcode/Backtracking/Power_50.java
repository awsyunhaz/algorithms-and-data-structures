package Leetcode.Backtracking;

public class Power_50 {
    public double myPow(double x, long n) {
        if (n == Integer.MIN_VALUE) {
            return myPow(x*x, n/2);
        }
        if (n < 0) {
            return myPow(1/x, -n);
        }
        if (n == 0) {
            return 1.0;
        }
        double half = myPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
