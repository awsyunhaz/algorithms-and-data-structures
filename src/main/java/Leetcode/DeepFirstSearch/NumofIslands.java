package Leetcode.DeepFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class NumofIslands {
    // DFS - 1ms
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j]=='1'){
                    res++;
                    search(grid, i, j);
                }
            }
        }
        return res;
    }

    public void search(char[][] grid, int i, int j){
        grid[i][j] = '0';
        if (i<grid.length-1 && grid[i+1][j]=='1') search(grid, i+1, j);
        if (j<grid[0].length-1 && grid[i][j+1]=='1') search(grid, i, j+1);
        if (i>0 && grid[i-1][j]=='1') search(grid, i-1, j);
        if (j>0 && grid[i][j-1]=='1') search(grid, i, j-1);
    }

    // BFS - 4ms
//    public int numIslands(char[][] grid) {
//        if (grid==null || grid.length==0)
//            return 0;
//        Queue<Integer> queue = new LinkedList<>();
//        int res = 0, num_row = grid.length, num_col = grid[0].length;
//        for (int i = 0; i < num_row; i++){
//            for (int j = 0; j < num_col; j++){
//                if (grid[i][j] == '1') {
//                    grid[i][j] = '0';
//                    res++;
//                    queue.add(i*num_col + j);
//                    while (!queue.isEmpty()){
//                        int id = queue.remove();
//                        int row = id / num_col, col = id % num_col;
//                        if (row>0 && grid[row-1][col] == '1'){
//                            queue.add((row-1)*num_col + col);
//                            grid[row-1][col] = '0';
//                        }
//                        if (col>0 && grid[row][col-1] == '1'){
//                            queue.add(row*num_col + col-1);
//                            grid[row][col-1] = '0';
//                        }
//                        if (row<num_row-1 && grid[row+1][col] == '1'){
//                            queue.add((row+1)*num_col + col);
//                            grid[row+1][col] = '0';
//                        }
//                        if (col<num_col-1 && grid[row][col+1] == '1'){
//                            queue.add(row*num_col + col+1);
//                            grid[row][col+1] = '0';
//                        }
//
//                    }
//                }
//            }
//        }
//        return res;
//    }
}
