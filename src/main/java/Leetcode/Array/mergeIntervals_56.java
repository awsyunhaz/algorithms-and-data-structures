package Leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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

    // Priority Queue - 5ms
//    public int[][] merge(int[][] intervals) {
//        if (intervals.length == 0) {
//            return new int[][]{};
//        }
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
//        for (int[] interval: intervals) {
//            pq.offer(interval);
//        }
//        List<int[]> lis = new ArrayList<>();
//        int[] interval = pq.poll();
//        int start = interval[0], end = interval[1];
//        while (!pq.isEmpty()) {
//            interval = pq.poll();
//            if (interval[0] > end) {
//                lis.add(new int[]{start, end});
//                start = interval[0];
//            }
//            if (interval[1] > end) {
//                end = interval[1];
//            }
//        }
//        lis.add(new int[]{start, end});
//
//        int[][] res = new int[lis.size()][2];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = lis.get(i);
//        }
//        return res;
//    }
}
