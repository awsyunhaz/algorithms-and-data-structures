package Leetcode.Tree.BinarySearchTree;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar_729 {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar_729() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> lastEvent = calendar.floorEntry(start);
        Map.Entry<Integer, Integer> nextEvent = calendar.ceilingEntry(start);
        if (lastEvent != null && lastEvent.getValue() > start || nextEvent != null && nextEvent.getKey() < end) {
            return false;
        }
        calendar.put(start, end);
        return true;
    }
}
