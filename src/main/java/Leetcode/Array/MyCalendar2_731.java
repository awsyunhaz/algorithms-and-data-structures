package Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar2_731 {
    List<int[]> calendar;
    List<int[]> overlaps;

    public MyCalendar2_731() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] event: overlaps) {
            if (event[0] < end && event[1] > start) {
                return false;
            }
        }
        for (int[] event: calendar) {
            if (event[0] < end && event[1] > start) {
                overlaps.add(new int[]{Math.max(start, event[0]), Math.min(end, event[1])});
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}
