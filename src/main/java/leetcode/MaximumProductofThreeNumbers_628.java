package leetcode;

import java.util.Arrays;

public class MaximumProductofThreeNumbers_628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        return Math.max(
                nums[len]*nums[len-1]*nums[len-2],
                nums[len]*nums[0]*nums[1]);
    }
}
