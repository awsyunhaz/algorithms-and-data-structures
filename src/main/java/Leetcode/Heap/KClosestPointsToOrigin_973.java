package Leetcode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {

    // Priority Queue - Nlog(k)
//    public int[][] kClosest(int[][] points, int K) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]));
//        int[][] res = new int[K][2];
//        for (int[] p: points) {
//            pq.offer(p);
//        }
//        for (int i = 0; i < K; i++) {
//            res[i] = pq.poll();
//        }
//        return res;
//    }

    // Quick select
    public int[][] kClosest(int[][] points, int K) {
        int lo = 0, hi = points.length-1, p = -1;
        while (p != K-1) {
            p = partition(points, lo, hi);
            if (p < K) {
                lo = p + 1;
            } else {
                hi = p - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    public int partition(int[][] points, int lo, int hi) {
        int[] pivot = points[lo];
        while (lo < hi) {
            while (lo < hi && dist(points[hi]) >= dist(pivot))
                hi --;
            points[lo] = points[hi];
            while (lo < hi && dist(points[lo]) < dist(pivot))
                lo ++;
            points[hi] = points[lo];
        }
        points[lo] = pivot;
        return lo;
    }

    public int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
