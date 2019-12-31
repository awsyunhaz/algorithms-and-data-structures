package Leetcode.Array;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]-1 >= 0 &&  nums[i]-1 < nums.length && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i--] = tmp;
            }
        }
        int i = 0;
        while (i < nums.length && nums[i] == i+1) {
            i++;
        }
        return i+1;
    }
}
