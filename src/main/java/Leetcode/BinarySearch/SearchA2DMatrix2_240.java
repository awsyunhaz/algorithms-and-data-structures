package Leetcode.BinarySearch;

public class SearchA2DMatrix2_240 {

    // O(mlogn)
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0 || matrix[0].length == 0) {
//            return false;
//        }
//        int m = matrix.length, n = matrix[0].length;
//        for (int i = 0; i < m; i++) {
//            int lo = 0, hi = n - 1;
//            while (lo <= hi) {
//                int mid = (lo + hi) / 2;
//                if (matrix[i][mid] == target) {
//                    return true;
//                } else if (matrix[i][mid] < target) {
//                    lo = mid + 1;
//                } else {
//                    hi = mid - 1;
//                }
//            }
//        }
//        return false;
//    }

    // O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n-1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row ++;
            } else {
                col --;
            }
        }
        return false;
    }
}
