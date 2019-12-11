package Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    // Simulation
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] added = new boolean[m][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0, row = 0, col = 0;
        for (int i = 0; i < m*n; i++) {
            res.add(matrix[row][col]);
            added[row][col] = true;
            int nextRow = row + dirs[dir][0], nextCol = col + dirs[dir][1];
            if (nextRow < 0 || nextRow == m || nextCol < 0 || nextCol == n || added[nextRow][nextCol]) {
                dir = (dir+1) % 4;
            }
            row += dirs[dir][0];
            col += dirs[dir][1];
        }
        return res;
    }

    // O(1) space
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> res = new ArrayList<>();
//        if (matrix.length == 0 || matrix[0].length == 0)
//            return res;
//        int rowStart = 0, rowEnd = matrix.length - 1;
//        int colStart = 0, colEnd = matrix[0].length - 1;
//        int dir = 0, row = 0, col = 0;
//        while (rowStart <= rowEnd && colStart <= colEnd) {
//            res.add(matrix[row][col]);
//            if (dir == 0) {
//                if (col == colEnd) {
//                    dir = 1;
//                    rowStart ++;
//                    row ++;
//                } else {
//                    col ++;
//                }
//            } else if (dir == 1) {
//                if (row == rowEnd) {
//                    dir = 2;
//                    colEnd --;
//                    col --;
//                } else {
//                    row ++;
//                }
//            } else if (dir == 2) {
//                if (col == colStart) {
//                    dir = 3;
//                    rowEnd --;
//                    row --;
//                } else {
//                    col --;
//                }
//            } else {
//                if (row == rowStart) {
//                    dir = 0;
//                    colStart ++;
//                    col ++;
//                } else {
//                    row --;
//                }
//            }
//        }
//        return res;
//    }
}
