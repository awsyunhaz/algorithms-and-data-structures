package Leetcode.BitManipulation;

public class SingleNumber3_260 {
    public int[] singleNumber(int[] nums) {
        int mask = 0;
        for (int num: nums) {
            mask ^= num;
        }
        // the least significant i where two single numbers diff on
        int diff = mask & ~(mask - 1);
        int res = 0;
        for (int num: nums) {
            // all numbers with ith bit = 1
            if ((num & diff) == 0) {
                res ^= num;
            }
        }
        return new int[]{res, mask^res};
    }
}
