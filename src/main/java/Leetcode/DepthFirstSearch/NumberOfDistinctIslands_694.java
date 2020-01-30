package Leetcode.DepthFirstSearch;

import java.util.HashSet;

public class NumberOfDistinctIslands_694 {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        HashSet<String> islandSet = new HashSet<>();
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                StringBuffer sb = new StringBuffer();
                dfs(grid, i, j, 0, 0, sb);
                if (sb.length() > 0 && !islandSet.contains(sb.toString())) {
                    res ++;
                    islandSet.add(sb.toString());
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j, int x_rel, int y_rel, StringBuffer sb) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        sb.append(x_rel + " " + y_rel + ",");
        grid[i][j] = 0;
        for (int[] dir: dirs) {
            dfs(grid, i+dir[0], j+dir[1], x_rel+dir[0], y_rel+dir[1], sb);
        }
    }
}
