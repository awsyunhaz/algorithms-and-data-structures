package Leetcode.Math;

public class ConsecutiveNumbersSum_829 {
    public int consecutiveNumbersSum(int N) {
        int res = 1;
        for (int i = 2; i < Math.sqrt(2*N); i++) {
            if (i % 2 == 1 && N % i == 0 || i % 2 == 0 && N % i == i/2) {
                res ++;
            }
        }
        return res;
    }
}
