package Leetcode.Array;

public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int sum = 0, lsum = 0;
        for (int num: nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = sum - nums[i];
            if (tmp%2 == 0 && tmp/2 == lsum) {
                return i;
            }
            lsum += nums[i];
        }
        return -1;
    }
}
