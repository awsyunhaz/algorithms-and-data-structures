package Leetcode.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference_539 {
    // O(nlogn)
//    public int findMinDifference(List<String> timePoints) {
//        List<Integer> minutes = new ArrayList<>();
//        for (String tp: timePoints) {
//            int hour = Integer.valueOf(tp.split(":")[0]);
//            int minute = Integer.valueOf(tp.split(":")[1]);
//            minutes.add(hour*60 + minute);
//        }
//        Collections.sort(minutes);
//        int minDiff = 1440;
//        for (int i = 0; i < minutes.size()-1; i++) {
//            minDiff = Math.min(minDiff, minutes.get(i+1) - minutes.get(i));
//        }
//        minDiff = Math.min(minDiff, minutes.get(0)+1440 - minutes.get(minutes.size()-1));
//        return minDiff;
//    }

    // O(1440)
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[1440];
        for (String tp: timePoints) {
            int hour = Integer.valueOf(tp.split(":")[0]);
            int minute = Integer.valueOf(tp.split(":")[1]);
            int t = hour*60 + minute;
            if (minutes[t]) {
                return 0;
            } else {
                minutes[t] = true;
            }
        }
        int minDiff = 1440, firstT = 1440, lastT = 0;
        for (int t = 0; t < 1440; t++) {
            if (minutes[t]) {
                if (firstT == 1440) {
                    firstT = t;
                } else {
                    minDiff = Math.min(minDiff, t - lastT);
                }
                lastT = t;
            }
        }
        minDiff = Math.min(minDiff, firstT + 1440 - lastT);
        return minDiff;
    }
}
