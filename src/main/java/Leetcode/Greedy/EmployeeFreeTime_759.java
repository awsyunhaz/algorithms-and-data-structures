package Leetcode.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime_759 {
    /*
    Definition for an Interval.
     */
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();
        for (List<Interval> sche: schedule) {
            allIntervals.addAll(sche);
        }
        Collections.sort(allIntervals, (a, b) -> (a.start - b.start));
        List<Interval> res = new ArrayList<>();
        int endTime = allIntervals.get(0).end;
        for (Interval interval: allIntervals) {
            if (interval.start > endTime) {
                res.add(new Interval(endTime, interval.start));
            }
            endTime = Math.max(endTime, interval.end);
        }
        return res;
    }
}
