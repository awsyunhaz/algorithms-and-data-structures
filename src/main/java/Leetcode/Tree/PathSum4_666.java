package Leetcode.Tree;

import java.util.Arrays;

public class PathSum4_666 {
    public int pathSum(int[] nums) {
        Arrays.sort(nums);
        int[][] pathCount = new int[5][8];
        int res = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            int d = nums[i] / 100;
            int p = nums[i] / 10 % 10 - 1;
            if (pathCount[d][p] == 0) {
                pathCount[d][p] = 1;
            }
            res += nums[i] % 10 * pathCount[d][p];
            // Add path count to parent
            pathCount[d-1][p/2] += pathCount[d][p];
        }
        return res;
    }
}
