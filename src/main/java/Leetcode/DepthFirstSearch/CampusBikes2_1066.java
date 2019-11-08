package Leetcode.DepthFirstSearch;

public class CampusBikes2_1066 {
    // DFS + pruning
    private int minDis = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] assigned = new boolean[bikes.length];
        search(workers, bikes, 0, assigned, 0);
        return minDis;
    }

    public void search(int[][] workers, int[][] bikes, int w, boolean[] assigned, int dis) {
        if (w == workers.length) {
            minDis = Math.min(dis, minDis);
            return;
        }
        if (dis >= minDis) {
            return;
        }
        for (int b = 0; b < bikes.length; b++) {
            if (!assigned[b]){
                assigned[b] = true;
                int[] coor_w = workers[w];
                int[] coor_b = bikes[b];
                int newDis = Math.abs(coor_w[0] - coor_b[0]) + Math.abs(coor_w[1] - coor_b[1]);
                search(workers, bikes, w+1, assigned, dis+newDis);
                assigned[b] = false;
            }
        }
    }
}
