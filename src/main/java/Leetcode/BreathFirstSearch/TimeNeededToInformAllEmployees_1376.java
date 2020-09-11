package Leetcode.BreathFirstSearch;

import java.util.*;

public class TimeNeededToInformAllEmployees_1376 {
    // BFS
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, List<Integer>> subs = new HashMap<>();
        for (int id = 0; id < manager.length; id++) {
            if (!subs.containsKey(manager[id])) {
                subs.put(manager[id], new ArrayList<>());
            }
            subs.get(manager[id]).add(id);
        }
        queue.add(new int[]{headID, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int[] employee = queue.poll();
            int id = employee[0], time = employee[1];
            if (subs.containsKey(id)) {
                for (int subId: subs.get(id)) {
                    queue.add(new int[]{subId, time + informTime[id]});
                }
            } else {
                res = Math.max(res, time);
            }
        }
        return res;
    }

    // DFS
//    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//        Map<Integer, List<Integer>> subs = new HashMap<>();
//        for (int id = 0; id < n; id++) {
//            if (!subs.containsKey(manager[id])) {
//                subs.put(manager[id], new ArrayList<>());
//            }
//            subs.get(manager[id]).add(id);
//        }
//        return numOfMinutes(headID, subs, informTime);
//    }
//
//    public int numOfMinutes(int id, Map<Integer, List<Integer>> subs, int[] informTime) {
//        if (!subs.containsKey(id)) {
//            return 0;
//        }
//        // Maximum time needed to inform all subordinates
//        int max = 0;
//        for (int subId: subs.get(id)) {
//            max = Math.max(max, numOfMinutes(subId, subs, informTime));
//        }
//        return informTime[id] + max;
//    }
}
