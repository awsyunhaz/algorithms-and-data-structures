package Leetcode;

import java.util.Arrays;

public class MeetingRooms_252 {
//    public boolean canAttendMeetings(int[][] intervals) {
//        int n = intervals.length;
//        int[] start = new int[n];
//        int[] end = new int[n];
//        for (int i = 0; i < n; i++) {
//            start[i] = intervals[i][0];
//            end[i] = intervals[i][1];
//        }
//        Arrays.sort(start);
//        Arrays.sort(end);
//        for (int i = 1; i < n; i++) {
//            if (start[i] < end[i-1])
//                return false;
//        }
//        return true;
//    }

    // sort 2d array, shorter but much slower
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i][0] < intervals[i-1][1])
                return false;
        }
        return true;
    }
}
