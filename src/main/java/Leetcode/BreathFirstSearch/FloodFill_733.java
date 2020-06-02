package Leetcode.BreathFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill_733 {

    // BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        int sourceColor = image[sr][sc];
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir: dirs) {
                int row = p[0] + dir[0], col = p[1] + dir[1];
                if (row >= 0 && col >= 0 && row < m && col < n && !visited[row][col] && image[row][col] == sourceColor) {
                    visited[row][col] = true;
                    image[row][col] = newColor;
                    queue.add(new int[]{row, col});
                }
            }
        }
        return image;
    }

    // DFS
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//        boolean[][] visited = new boolean[image.length][image[0].length];
//        flood(image, sr, sc, image[sr][sc], newColor, visited, dirs);
//        return image;
//    }
//
//    public void flood(int[][] image, int sr, int sc, int sourceColor, int newColor, boolean[][] visited, int[][] dirs) {
//        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length && !visited[sr][sc] && image[sr][sc] == sourceColor) {
//            image[sr][sc] = newColor;
//            visited[sr][sc] = true;
//            for (int[] dir: dirs) {
//                int row = sr + dir[0], col = sc + dir[1];
//                flood(image, row, col, sourceColor, newColor, visited, dirs);
//            }
//        }
//    }
}
