package Leetcode.Greedy;

import java.util.HashMap;
import java.util.HashSet;

public class FlowerPaintingWithNoAdjacent_1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] p: paths) {
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        int[] res = new int[N];
        for (int i = 1; i <= N; i++) {
            boolean[] colors = new boolean[5];
            for (int neigh: graph.get(i)) {
                if (res[neigh-1] > 0) {
                    colors[res[neigh-1]] = true;
                }
            }
            for (int c = 1; c <= 4; c++) {
                if (!colors[c]) {
                    res[i-1] = c;
                    break;
                }
            }
        }
        return res;
    }
}
