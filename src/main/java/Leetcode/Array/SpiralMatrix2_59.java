package Leetcode.Array;

public class SpiralMatrix2_59 {
    // 0ms
//    public int[][] generateMatrix(int n) {
//        int rowStart = 0, rowEnd = n-1, colStart = 0, colEnd = n-1, num = 1;
//        int[][] res = new int[n][n];
//        while(num <= n*n){
//            for (int col = colStart; col <= colEnd; col++)
//                res[rowStart][col] = num++;
//            rowStart++;
//            for (int row = rowStart; row <= rowEnd; row++)
//                res[row][colEnd] = num++;
//            colEnd--;
//            for (int col = colEnd; col>=colStart; col--)
//                res[rowEnd][col] = num++;
//            rowEnd--;
//            for (int row = rowEnd; row >= rowStart; row--)
//                res[row][colStart] = num++;
//            colStart++;
//        }
//        return res;
//    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0, row = 0, col = 0;
        for (int i = 1; i <= n*n; i++) {
            res[row][col] = i;
            int nextRow = row + dirs[dir][0], nextCol = col + dirs[dir][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] > 0) {
                dir = (dir + 1) % 4;
            }
            row += dirs[dir][0];
            col += dirs[dir][1];
        }
        return res;
    }

}
