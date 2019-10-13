package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
        List<int[]> res = new ArrayList<>();
        int[] currInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currInterval[1]) {
                currInterval[0] = Math.min(currInterval[0], intervals[i][0]);
                currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
            }
            else {
                res.add(currInterval);
                currInterval = intervals[i];
            }
        }
        res.add(currInterval);
        return res.toArray(new int[res.size()][2]);
    }
}
