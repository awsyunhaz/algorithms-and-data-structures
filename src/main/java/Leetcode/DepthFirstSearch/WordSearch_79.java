package Leetcode.DepthFirstSearch;

public class WordSearch_79 {
    // DFS - 125ms
//    public boolean exist(char[][] board, String word) {
//        if (board == null || board.length == 0) return false;
//        int m = board.length, n = board[0].length;
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//                boolean[][] used = new boolean[m][n];
//                if (search(board, used, word, 0, i, j))
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean search(char[][] board, boolean[][] used, String word, int pos, int i, int j){
//        if (pos == word.length())  return true;
//        int m = board.length, n = board[0].length;
//        if (i < 0 || j < 0 || i == m || j == n
//                || used[i][j] || board[i][j] != word.charAt(pos)) return false;
//        used[i][j] = true;
//        if (search(board, used, word, pos+1, i-1, j)
//                || search(board, used, word, pos+1, i+1, j)
//                || search(board, used, word, pos+1, i, j-1)
//                || search(board, used, word, pos+1, i, j+1))
//            return true;
//        else{
//            used[i][j] = false;
//            return false;
//        }
//    }

    //Modified DFS - 3ms
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (search(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int pos, int i, int j){
        if (pos == word.length())  return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i == m || j == n
                || board[i][j] != word.charAt(pos)) return false;
        char c = board[i][j];
        board[i][j] = ' ';
        if (search(board, word, pos+1, i-1, j)
                || search(board, word, pos+1, i+1, j)
                || search(board, word, pos+1, i, j-1)
                || search(board, word, pos+1, i, j+1))
            return true;
        else{
            board[i][j] = c;
            return false;
        }
    }
}
