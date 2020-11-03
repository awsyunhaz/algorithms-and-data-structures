package Leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int startTime = Math.max(A[i][0], B[j][0]);
            int endTime = Math.min(A[i][1], B[j][1]);
            if (startTime <= endTime) {
                res.add(new int[]{startTime, endTime});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
