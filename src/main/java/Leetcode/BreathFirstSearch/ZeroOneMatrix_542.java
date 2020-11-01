package Leetcode.BreathFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix_542 {

    // DFS TLE
//    public int[][] updateMatrix(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        int[][] res = new int[m][n];
//        for (int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix[0].length; j++){
//                boolean[][] visited = new boolean[m][n];
//                res[i][j] = search(matrix, visited, i, j);
//            }
//        }
//        return res;
//    }
//
//    public int search(int[][] matrix, boolean[][] visited, int i, int j){
//        if (matrix[i][j] == 0)
//            return 0;
//        visited[i][j] = true;
//        int up = 10000, down = 10000, left = 10000, right = 10000;
//        if (i-1 >= 0 && !visited[i-1][j]) up = search(matrix, visited, i-1, j);
//        if (i+1 < matrix.length && !visited[i+1][j]) down = search(matrix, visited, i+1, j);
//        if (j-1 >= 0 && !visited[i][j-1]) left = search(matrix, visited, i, j-1);
//        if (j+1 < matrix[0].length && !visited[i][j+1]) right = search(matrix, visited, i, j+1);
//        visited[i][j] = false;
//        return Math.min(Math.min(Math.min(up, down), left), right) + 1;
//    }

    // BFS - 12ms
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir: dirs) {
                int row = pos[0] + dir[0], col = pos[1] + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    matrix[row][col] = matrix[pos[0]][pos[1]] + 1;
                    queue.add(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }

        return matrix;
    }

    // DP - 7ms !corner case in the right bottom item
//    public int[][] updateMatrix(int[][] matrix) {
//        int row = matrix.length, col = matrix[0].length;
//        for (int i = 0; i < row; i++){
//            for (int j = 0; j < col; j++){
//                if (matrix[i][j] == 1)
//                    matrix[i][j] = 10000;
//            }
//        }
//
//        for (int i = 0; i < row; i++){
//            for (int j = 0; j < col; j++){
//                if (matrix[i][j] == 0) continue;
//                int up = 10000, left = 10000;
//                if (i-1 >= 0) up = matrix[i-1][j];
//                if (j-1 >= 0) left = matrix[i][j-1];
//                matrix[i][j] = Math.min(up, left) + 1;
//            }
//        }
//
//        for (int i = row-1; i >= 0; i--){
//            for (int j = col-1; j >= 0; j--){
//                if (matrix[i][j] == 0) continue;
//                int down = 10000, right = 10000;
//                if (i+1 < row) down = matrix[i+1][j];
//                if (j+1 < col) right = matrix[i][j+1];
//                matrix[i][j] = Math.min(Math.min(down, right) +1, matrix[i][j]);
//            }
//        }
//        return matrix;
//    }
}
