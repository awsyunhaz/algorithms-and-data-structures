package Leetcode.Heap;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix_378 {

    // Min heap - 29ms
//    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//        for (int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix[0].length; j++){
//                pq.offer(matrix[i][j]);
//            }
//        }
//        for (int i = 0; i < k - 1; i++){
//            pq.poll();
//        }
//        return pq.poll();
//    }

    // Min heap row-wise push - 18ms
//    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<HeapNode> pq = new PriorityQueue<HeapNode>((n1, n2) -> (n1.key-n2.key));
//        for (int j = 0; j < matrix[0].length; j++){
//            pq.offer(new HeapNode(matrix[0][j], 0, j));
//        }
//        while(k > 0){
//            k--;
//            HeapNode node = pq.poll();
//            if (k == 0)
//                return node.key;
//            if (node.row < matrix.length - 1)
//                pq.offer(new HeapNode(matrix[node.row+1][node.col], node.row+1, node.col));
//        }
//        return 0;
//    }
//
//    class HeapNode{
//        int key, row, col;
//        public HeapNode(int key, int row, int col){
//            this.key = key;
//            this.row = row;
//            this.col = col;
//        }
//    }

    // Binary search - 5ms
    public int kthSmallest(int[][] matrix, int k) {
        int num_row = matrix.length, num_col = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[num_row-1][num_col-1];
        while (lo < hi){
            int mid = (lo + hi) / 2;
            int rank = 0; // rank of mid in matrix
            for (int i = 0; i < num_row; i++){
                int j = 0;
                while (j < num_col && matrix[i][j] <= mid){
                    j ++;
                    rank ++;
                }
            }
            if (rank < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
