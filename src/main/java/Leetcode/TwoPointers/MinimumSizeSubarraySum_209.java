package Leetcode.TwoPointers;

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, res = nums.length+1;
        while (hi < nums.length) {
            if (sum < s) {
                sum += nums[hi++];
            }
            while (sum >= s) {
                res = Math.min(res, hi - lo);
                sum -= nums[lo++];
            }
        }
        return res == nums.length+1? 0: res;
    }
}
