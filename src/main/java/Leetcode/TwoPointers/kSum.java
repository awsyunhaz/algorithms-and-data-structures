package Leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kSum {
    public List<List<Integer>> kSum(int[] nums, int target, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        kSum(res, curr, nums, k, target, 0);
        return res;
    }

    public void kSum(List<List<Integer>> res, List<Integer> curr, int[] nums, int k, int target, int start) {
        // solve twoSum
        if (k == 2) {
            int lo = start, hi = nums.length-1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == target) {
                    List<Integer> tmp = new ArrayList<>(curr);
                    tmp.add(nums[lo]);
                    tmp.add(nums[hi]);
                    res.add(new ArrayList<>(tmp));
                    while (lo < hi && nums[lo] == nums[++lo]);
                    while (lo < hi && nums[hi] == nums[--hi]);
                } else if (sum < target) {
                    lo ++;
                } else {
                    hi --;
                }
            }
        } else {
            // reduce to k-1 sum
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) {
                    continue;
                }
                curr.add(nums[i]);
                kSum(res, curr, nums, k-1, target-nums[i], i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
}
