package Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(getRange(lower, upper));
            return res;
        }
        if (nums[0] > lower) {
            res.add(getRange(lower, nums[0]-1));
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1] && nums[i] < nums[i+1] - 1) {
                res.add(getRange(nums[i]+1, nums[i+1]-1));
            }
        }
        if (nums[nums.length-1] < upper) {
            res.add(getRange(nums[nums.length-1]+1, upper));
        }
        return res;
    }

    private String getRange(int start, int end) {
        if (start == end) {
            return Integer.toString(start);
        } else {
            return (Integer.toString(start) + "->" + Integer.toString(end));
        }
    }
}
