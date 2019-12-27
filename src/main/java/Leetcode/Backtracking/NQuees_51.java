package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQuees_51 {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    board[i][j] = '.';
                }
            }
            List<List<String>> res = new ArrayList<>();
            solve(res, board, n, n, 0);
            return res;
        }

        public void solve(List<List<String>> res, char[][] board, int curr, int n, int start){
            if (curr == 0){
                res.add(toRes(board));
                return;
            }
            for (int ind = start; ind < n*n; ind++){
                int i = ind/n, j = ind%n;
                if (board[i][j] == '.' && isValid(board, i, j, n)){
                    board[i][j] = 'Q';
                    solve(res, board, curr-1, n, i*n+j+1);
                    board[i][j] = '.';
                }
            }
        }

        public boolean isValid(char[][] board, int row, int col, int n){
            for (int i = 0; i < n; i++){
                if (board[i][col] == 'Q')
                    return false;
            }
            for (int j = 0; j < n; j++){
                if (board[row][j] == 'Q')
                    return false;
            }
            int[][] dirs = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
            for (int[] dir: dirs){
                for (int i = row + dir[0], j = col + dir[1]; i >= 0 && j >= 0 && i < n && j < n; i += dir[0], j += dir[1]){
                    if (board[i][j] == 'Q')
                        return false;
                }
            }
            return true;
        }

        public List<String> toRes(char[][] board){
            List<String> lis = new ArrayList<>();
            for (int i = 0; i < board.length; i++){
                lis.add(new String(board[i]));
            }
            return lis;
        }
    }
}
