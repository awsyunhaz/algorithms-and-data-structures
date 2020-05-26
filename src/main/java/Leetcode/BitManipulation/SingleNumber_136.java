package Leetcode.BitManipulation;

public class SingleNumber_136 {
    // Bit manipulation
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }
}
