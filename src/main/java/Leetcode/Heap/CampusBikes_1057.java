package Leetcode.Heap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class CampusBikes_1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        HashSet<Integer> bikeAssigned = new HashSet();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });
        for (int i = 0; i < workers.length; i++){
            for (int j = 0; j < bikes.length; j++){
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                pq.offer(new int[]{distance, i, j});
            }
        }

        while (bikeAssigned.size() < workers.length){
            int[] pair = pq.poll();
            if (res[pair[1]] == -1 && !bikeAssigned.contains(pair[2])){
                res[pair[1]] = pair[2];
                bikeAssigned.add(pair[2]);
            }
        }
        return res;
    }
}
