package Leetcode.Heap;

import java.util.*;

public class TheSkylineProblem_218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            // 0 for left side, 1 for right side
            heights.add(new int[]{b[0], b[2], -1});
            heights.add(new int[]{b[1], b[2], 1});
        }
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0]; // smaller index go first
            return a[1]*a[2] - b[1]*b[2]; // order: higher left, smaller left, smaller right, higher right
        });
        int max = 0;
        pq.offer(0);
        for (int[] h: heights) {
            if (h[2] == -1)
                pq.offer(h[1]);
            else
                pq.remove(h[1]);
            int newMax = pq.peek();
            if (newMax != max){
                res.add(Arrays.asList(h[0], newMax));
                max = pq.peek();
            }
        }
        return res;
    }
}
