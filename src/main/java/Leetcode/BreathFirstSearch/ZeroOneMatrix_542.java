package Leetcode.BreathFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix_542 {

    // DFS failed
//    public int[][] updateMatrix(int[][] matrix) {
//        int[][] res = new int[matrix.length][matrix[0].length];
//        Queue<Integer> queue = new LinkedList<Integer>();
//        for (int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix[0].length; j++){
//                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
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
//        return Math.min(Math.min(Math.min(up, down), left), right) + 1;
//    }

    // BFS - 17ms
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] ind = queue.poll();
            int i = ind[0], j = ind[1];

            for (int[] d: dir){
                int r = i + d[0], c = j + d[1];
                if (r < 0 || r >= row || c < 0 || c >= col || visited[r][c]) continue;
                matrix[r][c] = matrix[i][j] + 1;
                queue.offer(new int[]{r, c});
                visited[r][c] = true;
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
//
//            }
//        }
//        return matrix;
//    }
}
