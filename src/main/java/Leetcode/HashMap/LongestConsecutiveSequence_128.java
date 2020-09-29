package Leetcode.HashMap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LongestConsecutiveSequence_128 {
    // Priority queue
//    public int longestConsecutive(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int num: nums) {
//            pq.add(num);
//        }
//        int res = 0, count = 1, last = pq.peek();
//        while (!pq.isEmpty()) {
//            int num = pq.poll();
//            if (num == last + 1) {
//                count ++;
//            } else if (num > last + 1){
//                count = 1;
//            }
//            last = num;
//            res = Math.max(res, count);
//        }
//        return res;
//    }

    // O(n)
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> deleted = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int res = 0;
        for (int num: set) {
            if (!deleted.contains(num)) {
                int left = num-1, right = num+1;
                while (set.contains(left)) {
                    deleted.add(left --);
                }
                while (set.contains(right)) {
                    deleted.add(right ++);
                }
                deleted.add(num);
                res = Math.max(res, right-left-1);
            }
        }
        return res;
    }
}
