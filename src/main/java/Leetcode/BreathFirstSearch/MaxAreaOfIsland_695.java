package Leetcode.BreathFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int maxArea = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    int area = 1;
                    grid[i][j] = 0;
                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        for (int[] dir: dirs) {
                            int row = pos[0] + dir[0], col = pos[1] + dir[1];
                            if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                                queue.add(new int[]{row, col});
                                area ++;
                                grid[row][col] = 0;
                            }
                        }
                    }
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    // DFS
//    public int maxAreaOfIsland(int[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int m = grid.length, n = grid[0].length;
//        Queue<int[]> queue = new LinkedList<>();
//        int maxArea = 0;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                maxArea = Math.max(maxArea, computeArea(i, j, grid));
//            }
//        }
//        return maxArea;
//    }
//
//    public int computeArea(int i, int j, int[][] grid) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
//            return 0;
//        }
//        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
//        int area = 1;
//        grid[i][j] = 0;
//        for (int[] dir: dirs) {
//            area += computeArea(i + dir[0], j + dir[1], grid);
//        }
//        return area;
//    }
}
