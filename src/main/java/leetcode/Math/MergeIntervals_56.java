package leetcode.Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    class CompareByStart implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b){
            if (a.start < b.start) return -1;
            if (a.start == b.start) return 0;
            else return 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size()==0) return res;

        Collections.sort(intervals, new CompareByStart());
        for (int i=0; i<intervals.size()-1; i++){
            Interval left = intervals.get(i), right = intervals.get(i+1);
            if (left.end < right.start)
                res.add(left);
            else{
                Interval newInt = new Interval(Math.min(left.start, right.start),
                        Math.max(left.end, right.end));
                intervals.set(i+1, newInt);
            }
        }
        res.add(intervals.get(intervals.size()-1));
        return res;
    }
}
