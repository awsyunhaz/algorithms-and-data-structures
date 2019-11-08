package Leetcode.DepthFirstSearch;

public class NQueens2_52 {
    private int res = 0;
    private int[][] dirs = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        search(board, 0, 0, n);
        return res;
    }

    public void search(int[][] board, int start, int curr, int n){
        if (curr == n){
            res += 1;
            return;
        }
        for (int i = start; i < n*n; i++){
            int row = i / n, col = i % n;
            if (isValid(board, row, col, n)){
                board[row][col] = 1;
                search(board, i + 1, curr + 1, n);
                board[row][col] = 0;
            }
        }
    }

    public boolean isValid(int[][] board, int row, int col, int n){
        for (int i = 0; i < n; i++){
            if (board[i][col] == 1 || board[row][i] == 1)
                return false;
        }
        for (int[] dir: dirs){
            int r = row, c = col;
            while (r >= 0 && r < n && c >= 0 && c < n){
                if (board[r][c] == 1)
                    return false;
                r += dir[0];
                c += dir[1];
            }
        }
        return true;
    }
}
