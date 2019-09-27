package Leetcode.BreathFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge_934 {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestBridge(int[][] A) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        Queue<int[]> queue = new LinkedList<>();
        findIsland(A, visited, queue);
        return expandIsland(A, visited, queue);
    }

    public void findIsland(int[][] A, boolean[][] visited, Queue<int[]> queue){
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                if (A[i][j] == 1){
                    search(A, i, j, visited, queue);
                    return;
                }
            }
        }
    }

    //DFS: find an island
    public void search(int[][] A, int i, int j, boolean[][] visited, Queue<int[]> queue){
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] dir: dirs){
            int r = i + dir[0], c = j + dir[1];
            if (r >= 0 && r < A.length && c >= 0 && c < A[0].length && A[r][c] == 1 && !visited[r][c]){
                search(A, r, c, visited, queue);
            }
        }
    }

    //BFS: expand the island to find another
    public int expandIsland(int[][] A, boolean[][] visited, Queue<int[]> queue){
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int[] ind = queue.poll();
                for (int[] dir: dirs){
                    int r = ind[0] + dir[0], c = ind[1] + dir[1];
                    if (r >= 0 && r < A.length && c >= 0 && c < A[0].length){
                        if (A[r][c] == 1 && !visited[r][c])
                            return step;
                        if (A[r][c] == 0){
                            A[r][c] = 1;
                            visited[r][c] = true;
                            queue.offer(new int[]{r, c});
                        }
                    }
                }
            }
            step ++;
        }
        return 1;
    }
}
