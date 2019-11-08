package Leetcode.BinarySearch;

public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend>0 ^ divisor>0)
            sign = -1;
        long dividend_l = Math.abs((long)dividend);
        long divisor_l =  Math.abs((long)divisor);
        long res = search(dividend_l, divisor_l);
        // Corner case
        if (res>Integer.MAX_VALUE && sign==1)
            return Integer.MAX_VALUE;
        return (int)(sign*res);
    }

    private long search(long dividend, long divisor){
        if (dividend < divisor)
            return 0;
        long num = divisor;
        long res = 1;
        while (dividend>=num+num){
            num += num;
            res += res;
        }
        return res + search(dividend-num, divisor);
    }
}
