package Leetcode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MininumCostToConnectSticks_1167 {
    // PriorityQueue - 4*O(nlog(n!)) ~ 4*O(nlogn), 44ms
//    public int connectSticks(int[] sticks) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        int sum = 0;
//        for (int stick: sticks) {
//            pq.offer(stick);
//        }
//        while (pq.size() > 1) {
//            int a = pq.poll();
//            int b = pq.poll();
//            sum += a + b;
//            pq.offer(a+b);
//        }
//        return sum;
//    }

    // Sort O(nlogn)+ Greedy O(n), 21ms
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) {
            return 0;
        }
        Arrays.sort(sticks);
        ArrayList<Integer> arr = new ArrayList<>();
        int left = 0, right = 0, res = 0;
        while (left != sticks.length || right != arr.size()-1) {
            int[] s = new int[2];
            for (int i = 0; i < 2; i++) {
                if (left == sticks.length) {
                    s[i] = arr.get(right++);
                } else if (right == arr.size()) {
                    s[i] = sticks[left++];
                } else {
                    s[i] = sticks[left] < arr.get(right)? sticks[left++]: arr.get(right++);
                }
            }
            res += s[0] + s[1];
            arr.add(s[0] + s[1]);
        }
        return res;
    }
}
