package Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2_229 {
    // Boyer-Moore Voting Algorithm
    // O(n) time, O(1) space
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int cnt1 = 0, cnt2 = 0, max1 = nums[0], max2 = nums[0];
        for (int num: nums) {
            if (max1 == num) {
                cnt1 ++;
            } else if (max2 == num) {
                cnt2 ++;
            } else if (cnt1 == 0) {
                max1 = num;
                cnt1 ++;
            } else if (cnt2 == 0) {
                max2 = num;
                cnt2 ++;
            } else {
                cnt1 --;
                cnt2 --;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num: nums) {
            if (num == max1) {
                cnt1 ++;
            } else if (num == max2) {
                cnt2 ++;
            }
        }
        if (cnt1 > nums.length/3) {
            res.add(max1);
        }
        if (cnt2 > nums.length/3) {
            res.add(max2);
        }
        return res;
    }
}
