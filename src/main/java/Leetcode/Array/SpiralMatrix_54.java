package Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length==0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        int[][] added = new int[m][n];
        int dir = 0, i = 0, j = 0;
        while (added[i][j]<=1){
            if (added[i][j]==0)
                res.add(matrix[i][j]);
            added[i][j]++;
            switch (dir){
                case 0:
                    if (j+1<n && added[i][j+1]==0) j++;
                    else dir++;
                    break;
                case 1:
                    if (i+1<m && added[i+1][j]==0) i++;
                    else dir++;
                    break;
                case 2:
                    if (j-1>=0 && added[i][j-1]==0) j--;
                    else dir++;
                    break;
                case 3:
                    if (i-1>=0 && added[i-1][j]==0) i--;
                    else dir = 0;
                    break;
            }
        }
        return res;
    }
}
