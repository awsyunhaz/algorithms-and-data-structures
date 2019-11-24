package Leetcode.DynamicProgramming;

public class PartitionEqualSubsetSum_416 {
    // 2d DP
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int num: nums) {
//            sum += num;
//        }
//        if (sum % 2 != 0) {
//            return false;
//        }
//
//        int f[][] = new int[nums.length][sum/2+1];
//        for (int j = 0; j <= sum/2; j++) {
//            f[0][j] = j >= nums[0]? nums[0]: 0;
//        }
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j <= sum/2; j++) {
//                f[i][j] = f[i-1][j];
//                if (j >= nums[i]) {
//                    f[i][j] = Math.max(f[i][j], f[i-1][j-nums[i]] + nums[i]);
//                }
//            }
//        }
//        return f[nums.length-1][sum/2]==sum/2;
//    }

    // 1d DP
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int f[] = new int[sum/2+1];
        for (int i = 0; i < nums.length; i++) {
            // Loop backward: get f[j-num[i]] from previous status (i loop)
            // Because each item can be used only once
            for (int j = sum/2; j >= nums[i]; j--) {
                f[j] = Math.max(f[j], f[j-nums[i]] + nums[i]);
            }
        }
        return f[sum/2]==sum/2;
    }
}
