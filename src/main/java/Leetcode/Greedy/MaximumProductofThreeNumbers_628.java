package Leetcode.Greedy;

import java.util.Arrays;

public class MaximumProductofThreeNumbers_628 {

    // Sort - O(nlogn)
//    public int maximumProduct(int[] nums) {
//        Arrays.sort(nums);
//        int len = nums.length - 1;
//        return Math.max(
//                nums[len]*nums[len-1]*nums[len-2],
//                nums[len]*nums[0]*nums[1]);
//    }

    // One pass - O(n)
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num > max3) {
                max1 = max2;
                max2 = max3;
                max3 = num;
            } else if (num > max2) {
                max1 = max2;
                max2 = num;
            } else if (num > max1) {
                max1 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(min1*min2, max1*max2) * max3;
    }
}
