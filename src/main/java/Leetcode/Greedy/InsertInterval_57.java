package Leetcode.Greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int ind = 0;
        // add prev intervals
        while (ind < intervals.length && newInterval[0] > intervals[ind][1]) {
            res.add(intervals[ind++]);
        }
        // merge new interval
        while (ind < intervals.length && newInterval[1] >= intervals[ind][0]) {
            newInterval[0] = Math.min(intervals[ind][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[ind][1], newInterval[1]);
            ind ++;
        }
        res.add(newInterval);
        // merge succ intervals
        while (ind < intervals.length) {
            res.add(intervals[ind++]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
