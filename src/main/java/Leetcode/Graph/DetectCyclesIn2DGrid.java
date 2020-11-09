package Leetcode.Graph;

// Similar to detect cycles in undirected graph
public class DetectCyclesIn2DGrid {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && search(grid, visited, null, new int[]{i, j})) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] grid, boolean[][] visited, int[] parent, int[] pos) {
        if (visited[pos[0]][pos[1]]) {
            return true;
        }
        visited[pos[0]][pos[1]] = true;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir: dirs) {
            int row = pos[0] + dir[0], col = pos[1] + dir[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[pos[0]][pos[1]] == grid[row][col]) {
                // don't go back
                if (parent != null && row == parent[0] && col == parent[1]) {
                    continue;
                }
                if (search(grid, visited, pos, new int[]{row, col})) {
                    return true;
                }
            }
        }
        return false;
    }
}
