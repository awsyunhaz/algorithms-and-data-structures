package leetcode.DeepFirstSearch;

import java.util.HashSet;

public class SudokuSolver_37 {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    // 10ms
//    private boolean solve(char[][] board){
//        for (int i = 0; i < 9; i++){
//            for (int j = 0; j < 9; j++){
//                if (board[i][j]=='.'){
//                    for (char c = '1'; c <= '9'; c++){
//                        if (isValid(board, i, j, c)){
//                            board[i][j] = c;
//                            if (solve(board))
//                                return true;
//                            else
//                                board[i][j] = '.';
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    //DFS - 7ms
    private boolean solve(char[][] board, int pos){
        if (pos >= 81)
            return true;
        int i = pos/9, j = pos%9;
        if (board[i][j]=='.'){
            for (char c = '1'; c <= '9'; c++){
                if (isValid(board, i, j, c)){
                    board[i][j] = c;
                    if (solve(board, pos+1))
                        return true;
                    else
                        board[i][j] = '.';
                }
            }
            return false;
        }
        else
            return solve(board, pos+1);
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++){
            int m = i/3*3 + k/3;
            int n = j/3*3 + k%3;
            if (board[i][k]==c || board[k][j]==c || board[m][n]==c)
                return false;
        }
        return true;
    }
}
