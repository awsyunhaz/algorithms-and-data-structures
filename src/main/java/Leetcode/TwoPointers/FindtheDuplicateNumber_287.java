package Leetcode.TwoPointers;

import java.util.Arrays;

public class FindtheDuplicateNumber_287 {
    // Sort, O(nlgn)
//    public int findDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i+1]) {
//                return nums[i];
//            }
//        }
//        return 0;
//    }

    // Linked list cycle - leetcode 142
    // O(n)
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]], slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
