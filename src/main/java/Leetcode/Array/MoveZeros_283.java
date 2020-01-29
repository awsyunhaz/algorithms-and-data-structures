package Leetcode.Array;

public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
        int ind = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[ind];
                nums[ind++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
