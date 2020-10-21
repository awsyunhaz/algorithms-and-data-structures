package Leetcode.Greedy;

import java.util.Arrays;

public class UniversityCareerFair {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return (a[1] - a[0]) - (b[1] - b[0]);
            } else {
                return a[1] - b[1];
            }
        });
        int events = 0, endTime = Integer.MIN_VALUE;
        for (int[] interval: intervals){
            if (interval[0] >= endTime) {
                events ++;
                endTime = interval[1];
            }
        }
        return events;
    }
}
