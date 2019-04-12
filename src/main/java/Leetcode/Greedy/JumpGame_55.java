package Leetcode.Greedy;

public class JumpGame_55 {
//    // O(mn) - 237ms
//    public boolean canJump(int[] nums) {
//        if (nums.length<=1)
//            return true;
//        boolean[] reachable = new boolean[nums.length];
//        reachable[0] = true;
//        for (int i=0; i<nums.length; i++){
//            if (!reachable[i])
//                continue;
//            for (int j=i+1; j<=i+nums[i]; j++){
//                if (j==nums.length-1)
//                    return true;
//                reachable[j] = true;
//            }
//        }
//        return false;
//    }
//
//    //backtrack - TLE
//    public boolean canJump(int[] nums) {
//        return search(nums, 0);
//    }
//
//    private boolean search(int[] nums, int i){
//        if (i==nums.length-1)
//            return true;
//        for (int j=i+1; j<=Math.min(i+nums[i], nums.length-1); j++){
//            if (search(nums, j))
//                return true;
//        }
//        return false;
//    }

    // Greedy - O(n) 1ms
    public boolean canJump(int[] nums) {
        int lastPos = nums.length-1;
        for (int i=nums.length-1; i>=0; i--){
            if (i + nums[i] >= lastPos)
                lastPos = i;
        }
        return lastPos==0;

    }
}
