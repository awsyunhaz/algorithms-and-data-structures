package Leetcode.Array;

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi];
            if (sum >= s) {
                minLen = Math.min(minLen, hi-lo+1);
                sum -= (nums[lo++] + nums[hi]);
            } else {
                hi++;
            }
        }
        return minLen == Integer.MAX_VALUE? 0: minLen;
    }
}
