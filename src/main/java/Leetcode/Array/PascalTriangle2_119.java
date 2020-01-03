package Leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2_119 {
//    public List<Integer> getRow(int rowIndex) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(Arrays.asList(1));
//        for (int i = 1; i <= rowIndex; i++) {
//            List<Integer> arr = new ArrayList<>();
//            arr.add(1);
//            for (int j = 0; j < i-1; j++) {
//                arr.add(res.get(i-1).get(j) + res.get(i-1).get(j+1));
//            }
//            arr.add(1);
//            res.add(arr);
//        }
//        return res.get(rowIndex);
//    }

    // O(k) space
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex+1];
        res[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            // Backward
            for (int j = i; j >= 1; j--) {
                res[j] = (res[j] == null? 0: res[j]) + res[j-1];
            }
        }
        return Arrays.asList(res);
    }
}
