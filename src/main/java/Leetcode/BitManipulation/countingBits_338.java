package Leetcode.BitManipulation;

public class countingBits_338 {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            int lastBit = i & 1;
            res[i] = lastBit + res[i>>1];
        }
        return res;
    }
}
