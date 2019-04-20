package Leetcode.Array;

public class SpiralMatrix2_59 {
    // 0ms
    public int[][] generateMatrix(int n) {
        int rowStart = 0, rowEnd = n-1, colStart = 0, colEnd = n-1, num = 1;
        int[][] res = new int[n][n];
        while(num <= n*n){
            for (int col = colStart; col <= colEnd; col++)
                res[rowStart][col] = num++;
            rowStart++;
            for (int row = rowStart; row <= rowEnd; row++)
                res[row][colEnd] = num++;
            colEnd--;
            for (int col = colEnd; col>=colStart; col--)
                res[rowEnd][col] = num++;
            rowEnd--;
            for (int row = rowEnd; row >= rowStart; row--)
                res[row][colStart] = num++;
            colStart++;
        }
        return res;
    }
}
