package Leetcode.DeepFirstSearch;

import java.util.ArrayList;

public class SurroundRegions_130 {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    ArrayList<int[]> lis = new ArrayList<>();
                    boolean[][] visited = new boolean[m][n];
                    if (search(board, i, j, lis, visited)) {
                        for (int[] coor: lis) {
                            board[coor[0]][coor[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    public boolean search(char[][] board, int i, int j, ArrayList<int[]> lis, boolean[][] visited) {
        if (i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1)
            return false;
        lis.add(new int[]{i, j});
        visited[i][j] = true;
        for (int[] dir: dirs) {
            int row = i + dir[0], col = j + dir[1];
            if (board[row][col] == 'O' && !visited[row][col] && !search(board, row, col, lis, visited))
                return false;
        }
        return true;
    }
}
