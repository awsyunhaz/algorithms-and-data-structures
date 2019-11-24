package Leetcode.BreathFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, minute = 0;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh ++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            minute ++;
            int size = queue.size();
            while (size -- > 0) {
                int[] pos = queue.poll();
                for (int[] dir: dirs) {
                    int row = pos[0] + dir[0], col = pos[1] + dir[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        queue.offer(new int[]{row, col});
                        fresh --;
                        grid[row][col] = 2;
                        if (fresh == 0) {
                            return minute;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
