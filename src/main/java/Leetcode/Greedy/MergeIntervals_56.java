package Leetcode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals_56 {

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

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int[] interval: intervals) {
            // new interval start
            if (interval[0] > end) {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
                // overlapped interval
            } else {
                end = Math.max(end, interval[1]);
            }
        }
        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][2]);
    }
}
