package Leetcode.Array;

public class RotateImage_48 {
    // Transpose + swap the symmetry
//    public void rotate(int[][] matrix) {
//        for (int i=0; i<matrix.length; i++){
//            for (int j=i+1; j<matrix.length; j++){
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//
//        for (int i=0; i<matrix.length; i++){
//            for (int j=0; j<matrix.length/2; j++){
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[i][matrix.length-1-j];
//                matrix[i][matrix.length-1-j] = temp;
//            }
//        }
//    }

    // Rotate 4 each time
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i <= n/2; i++) {
            for (int j = i; j < n-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = temp;
            }
        }
    }
}
