package Leetcode.BinarySearch;

public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row_num = matrix.length, col_num = matrix[0].length;
        int len = row_num * col_num;
        int lo = 0, hi = len - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            int row = mid / col_num, col = mid % col_num;
            if (target > matrix[row][col])
                lo = mid + 1;
            else if (target < matrix[row][col])
                hi = mid - 1;
            else
                return true;
        }
        return false;
    }
}
