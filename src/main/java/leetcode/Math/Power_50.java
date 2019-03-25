package leetcode.Math;

public class Power_50 {
    public double myPow(double x, long n) {
        if (n==0) return 1;
        if (n<0) return myPow(1/x, -n);
        double sqr = myPow(x, n/2);
        return (n%2==0)? sqr*sqr: x*sqr*sqr;
    }
}
