package Leetcode.Backtracking;

public class WordSearch_79 {
    // DFS - 125ms
//    public boolean exist(char[][] board, String word) {
//        if (word.length() == 0) {
//            return true;
//        }
//        if (board.length == 0 || board[0].length == 0) {
//            return false;
//        }
//        int m = board.length, n = board[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                boolean[][] visited = new boolean[m][n];
//                visited[i][j] = true;
//                if (dfs(board, i, j, word, 0, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
//        if (board[i][j] != word.charAt(index)) {
//            return false;
//        } else if (index == word.length()-1) {
//            return true;
//        }
//        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//        for (int[] dir: dirs) {
//            int row = i + dir[0], col = j + dir[1];
//            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col]) {
//                visited[row][col] = true;
//                if (dfs(board, row, col, word, index+1, visited)) {
//                    return true;
//                }
//                visited[row][col] = false;
//            }
//        }
//        return false;
//    }

    //Modified DFS - 5ms
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int n_row = board.length, n_col = board[0].length;
        for (int i = 0; i < n_row; i++){
            for (int j = 0; j < n_col; j++){
                if (search(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int i, int j, int start){
        if (start == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start))
            return false;
        char c = board[i][j];
        // switch character to space to avoid visiting again
        board[i][j] = ' ';
        for (int[] dir: dirs){
            int row = i + dir[0], col = j + dir[1];
            if (search(board, word, row, col, start+1))
                return true;
        }
        board[i][j] = c;
        return false;
    }
}
