package Leetcode.DynamicProgramming;

public class StudentAttendanceRecord2_552 {

    // DP O(n)
    public int checkRecord(int n) {
        int MOD = 1000000007;
        // end with P
        long[] fP = new long[n+1];
        // end with L
        long[] fL = new long[n+1];
        fP[0] = 1; fP[1] = 1;
        fL[0] = 1; fL[1] = 1;
        for (int i = 2; i <= n; i++) {
            fP[i] = (fP[i-1] + fL[i-1]) % MOD;
            fL[i] = (fP[i-1] + fP[i-2]) % MOD;
        }
        long sum = fP[n] + fL[n];
        for (int i = 1; i <= n; i++) {
            // insert A
            long left = i == 1? 1: fP[i-1]+fL[i-1];
            long right = i == n? 1: fP[n-i]+fL[n-i];
            sum = (sum + left * right) % MOD;
        }
        return (int) sum;
    }

    // DP O(n)
//    public int checkRecord(int n) {
//        int MOD = 1000000007;
//        // No A
//        long[] fLP = new long[Math.max(n, 3)+1];
//        fLP[0] = 1;
//        fLP[1] = 2;
//        fLP[2] = 4;
//        fLP[3] = 7;
//        for (int i = 4; i <= n; i++) {
//            // f(___P) + f(___L) - f(___PLLL)
//            fLP[i] = (2*fLP[i-1] - fLP[i-4] + MOD) % MOD;
//        }
//        long fA = 0;
//        for (int i = 1; i <= n; i++) {
//            fA = (fA + fLP[i-1] * fLP[n-i]) % MOD;
//        }
//        return (int) (fLP[n] + fA) % MOD;
//    }
}
