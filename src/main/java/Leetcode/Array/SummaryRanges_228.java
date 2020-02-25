package Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            for (; j+1 < nums.length && nums[j]+1 == nums[j+1]; j++);
            if (j == i) {
                res.add(Integer.toString(nums[i]));
            } else {
                res.add(Integer.toString(nums[i]) + "->" + Integer.toString(nums[j]));
            }
            i = j;
        }
        return res;
    }
}
