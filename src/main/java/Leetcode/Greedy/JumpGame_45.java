package Leetcode.Greedy;

public class JumpGame_45 {
    public int jump(int[] nums) {
        int start = 0, end = 0, jumps = 0;
        while (end < nums.length-1) {
            int far = 0;
            for (int i = start; i <= end; i++) {
                far = Math.max(far, i+nums[i]);
            }
            start = end+1;
            end = far;
            jumps ++;
        }
        return jumps;
    }
}
