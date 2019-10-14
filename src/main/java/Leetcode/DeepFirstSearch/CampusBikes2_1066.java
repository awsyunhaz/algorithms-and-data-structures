package Leetcode.DeepFirstSearch;

public class CampusBikes2_1066 {
    private int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] assigned = new boolean[bikes.length];
        search(workers, bikes, 0, assigned, 0);
        return min;
    }

    public void search(int[][] workers, int[][] bikes, int w, boolean[] assigned, int cost) {
        if (w == workers.length) {
            min = Math.min(cost, min);
            return;
        }
        for (int b = 0; b < bikes.length; b++) {
            if (!assigned[b]){
                assigned[b] = true;
                int[] coor_w = workers[w];
                int[] coor_b = bikes[b];
                int dis = Math.abs(coor_w[0] - coor_b[0]) + Math.abs(coor_w[1] - coor_b[1]);
                search(workers, bikes, w+1, assigned, cost+dis);
                assigned[b] = false;
            }
        }
    }
}
