package Leetcode.Heap;

import java.util.PriorityQueue;

public class TrappingRainWater2_407 {
    // The maximum height of water for current container is determined by the lowest part of its boundary.
    // use priority queue to find the lowest boundary
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> boundary = new PriorityQueue<>(
                (a, b) -> heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]
        );
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int area = 0;

        for (int i = 0; i < m; i++) {
            boundary.add(new int[]{i, 0});
            boundary.add(new int[]{i, n-1});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        for (int j = 0; j < n; j++) {
            boundary.add(new int[]{0, j});
            boundary.add(new int[]{m-1, j});
            visited[0][j] = true;
            visited[m-1][j] = true;
        }
        while (!boundary.isEmpty()) {
            int[] pos = boundary.poll();
            int h = heightMap[pos[0]][pos[1]];
            for (int[] dir: dirs) {
                int row = pos[0] + dir[0], col = pos[1] + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    if (heightMap[row][col] < h) {
                        area += h - heightMap[row][col];
                        // replace the height with the higher boundary
                        heightMap[row][col] = h;
                    }
                    boundary.add(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        return area;
    }
}
