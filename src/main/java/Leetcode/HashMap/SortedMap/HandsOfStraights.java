package Leetcode.HashMap.SortedMap;

import java.util.*;

public class HandsOfStraights {
    // Sort, O(NlogN + NW)
//    public boolean isNStraightHand(int[] hand, int W) {
//        if (hand.length % W != 0) {
//            return false;
//        }
//
//        List<List<Integer>> groups = new ArrayList<>();
//        int groupNum = hand.length / W;
//        for (int i = 0; i < groupNum; i++) {
//            groups.add(new ArrayList<>());
//        }
//        int start = 0;
//
//        Arrays.sort(hand);
//        for (int num: hand) {
//            int i = start;
//            for (; i < groupNum; i++) {
//                List<Integer> group = groups.get(i);
//                if (group.isEmpty() || group.get(group.size()-1) == num-1) {
//                    group.add(num);
//                    if (group.size() == W) {
//                        start ++;
//                    }
//                    break;
//                }
//                if (group.get(group.size()-1) < num-1) {
//                    return false;
//                }
//            }
//            if (i == groupNum) {
//                return false;
//            }
//        }
//        return true;
//    }

    // Priority queue, O(NlogN)
//    public boolean isNStraightHand(int[] hand, int W) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int num: hand) {
//            pq.add(num);
//        }
//        while (!pq.isEmpty()) {
//            int num = pq.poll();
//            for (int i = 1; i < W; i++) {
//                if (!pq.remove(num+i)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    // Ordered map, O(NlogN)
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> counter = new TreeMap<>();
        for (int num: hand) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        for (int num: counter.keySet()) {
            int count = counter.get(num);
            if (count > 0) {
                counter.put(num, 0);
                for (int i = 1; i < W; i++) {
                    if (!counter.containsKey(num+i) || counter.get(num+i) < count) {
                        return false;
                    }
                    counter.put(num+i, counter.get(num+i) - count);
                }
            }
        }
        return true;
    }
}
