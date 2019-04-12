package Leetcode.DynamicProgramming;

public class UniquePaths2_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        int i = 0, j = 0;
        while (i < m && obstacleGrid[i][0]==0) f[i++][0] = 1;
        while (j < n && obstacleGrid[0][j]==0) f[0][j++] = 1;
        for (i = 1; i < m; i++){
            for (j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1 ||
                        obstacleGrid[i][j-1] == 1 && obstacleGrid[i-1][j] == 1)
                    continue;
                f[i][j] = (obstacleGrid[i-1][j]==1? 0:f[i-1][j]) +
                        (obstacleGrid[i][j-1]==1? 0:f[i][j-1]);
            }
        }
        return f[m-1][n-1];
    }
}
