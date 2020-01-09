package Leetcode.Graph;

import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue_1102 {
    public int maximumMinimumPath(int[][] A) {
        int m = A.length, n = A[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[2] - a[2]));
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[]{0, 0, A[0][0]});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            if (pos[0] == m-1 && pos[1] == n-1) {
                return pos[2];
            }
            for (int[] dir: dirs) {
                int row = pos[0] + dir[0], col = pos[1] + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    pq.offer(new int[]{row, col, Math.min(pos[2], A[row][col])});
                    visited[row][col] = true;
                }
            }
        }
        return -1;
    }
}
