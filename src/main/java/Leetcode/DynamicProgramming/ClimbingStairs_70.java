package Leetcode.DynamicProgramming;

// similar as Fibonacci number
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        int[] f = new int[n+2];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for (int i=3; i<=n; i++)
            f[i] = f[i-2] + f[i-1];
        return f[n];
    }
}
