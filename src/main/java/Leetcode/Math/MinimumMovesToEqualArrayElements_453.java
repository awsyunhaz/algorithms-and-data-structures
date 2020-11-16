package Leetcode.Math;

public class MinimumMovesToEqualArrayElements_453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int num: nums) {
            min = Math.min(min, num);
        }
        for (int num: nums) {
            res += num - min;
        }
        return res;
    }
}
