package Leetcode.Greedy;

import java.util.Arrays;

public class MeetingRooms2_253 {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int rooms = 0;
        for (int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        // j is the earliest ending time of all rooms
        int j = 0;
        for (int i = 0; i < intervals.length; i++){
            if (start[i] < end[j])
                rooms += 1;
            else
                j += 1;
        }
        return rooms;
    }
}
