package Leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            for (int j = 0; j < i-1; j++) {
                arr.add(res.get(i-1).get(j) + res.get(i-1).get(j+1));
            }
            arr.add(1);
            res.add(arr);
        }
        return res;
    }
}
