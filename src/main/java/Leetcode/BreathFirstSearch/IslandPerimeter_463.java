package Leetcode.BreathFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter_463 {

    // BFS, 12ms
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m*n; i++) {
            if (grid[i/n][i%n] == 1) {
                queue.add(new int[]{i/n, i%n});
                grid[i/n][i%n] = 2;
                break;
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir: dirs) {
                int row = pos[0] + dir[0], col = pos[1] + dir[1];
                if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
                    res ++;
                    continue;
                }
                if (grid[row][col] == 1) {
                    queue.offer(new int[]{row, col});
                    grid[row][col] = 2;
                }
            }
        }
        return res;
    }

    // DFS, 20ms
//    public int islandPerimeter(int[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int m = grid.length, n = grid[0].length;
//        int[] pos = new int[]{0, 0};
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1) {
//                    return dfs(grid, i, j);
//                }
//            }
//        }
//        return 0;
//    }
//
//    public int dfs(int[][] grid, int i, int j) {
//        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
//            return 1;
//        }
//        int res = 0;
//        if (grid[i][j] == 1) {
//            grid[i][j] = 2;
//            for (int[] dir: dirs) {
//                res += dfs(grid, i+dir[0], j+dir[1]);
//            }
//        }
//        return res;
//    }
}
