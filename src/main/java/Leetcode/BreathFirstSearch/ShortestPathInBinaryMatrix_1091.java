package Leetcode.BreathFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }
        int m = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        if (grid[0][0] == 1) {
            return -1;
        }
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int step = 1;
        if (m == 1) {
            return step;
        }
        while (!queue.isEmpty()) {
            step ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir: dirs) {
                    int row = pos[0] + dir[0], col = pos[1] + dir[1];
                    if (row >= 0 && row < m && col >= 0 && col < m && grid[row][col] == 0) {
                        if (row == m-1 && col == m-1) {
                            return step;
                        }
                        queue.offer(new int[]{row, col});
                        grid[row][col] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
