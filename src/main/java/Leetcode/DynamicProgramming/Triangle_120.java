package Leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {

    // O(n) space solution
//    public int minimumTotal(List<List<Integer>> triangle) {
//        List<Integer> sum = new ArrayList<>();
//        sum.add(triangle.get(0).get(0));
//        for (int i = 1; i < triangle.size(); i++) {
//            List<Integer> tmp = new ArrayList<>();
//            tmp.add(sum.get(0) + triangle.get(i).get(0));
//            for (int j = 1; j < i; j++) {
//                tmp.add(Math.min(sum.get(j-1), sum.get(j)) + triangle.get(i).get(j));
//            }
//            tmp.add(sum.get(i-1) + triangle.get(i).get(i));
//            sum = tmp;
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < triangle.size(); i++){
//            min = Math.min(min, sum.get(i));
//        }
//        return min;
//    }

    // 1d DP, O(n) space: Bottom up
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];
        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}
