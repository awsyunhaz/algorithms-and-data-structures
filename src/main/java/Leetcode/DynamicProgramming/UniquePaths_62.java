package Leetcode.DynamicProgramming;

public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        //DP solution
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++)
            f[i][0] = 1;
        for (int j = 0; j < n; j++)
            f[0][j] = 1;
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++)
                f[i][j] = f[i-1][j] + f[i][j-1];
        }
        return f[m-1][n-1];
//        search(m, n, 0, 0);
//        return count;
    }

    // Backtracking solution: O(2^(m+n)) - time limit error
//    private int search (int m, int n, int i, int j){
//        if (i >= m || j >= n)
//            return 0;
//        if (i==m-1 && j==n-1){
//            return 1;
//        }
//        return search(m, n, i+1, j) + search(m, n, i, j+1);
//    }
}
