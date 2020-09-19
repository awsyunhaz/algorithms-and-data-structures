package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorCombinations_254 {

    // O(n^2)
//    public List<List<Integer>> getFactors(int n) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        getFactors(res, list, n, 2);
//        return res;
//    }
//
//    public void getFactors(List<List<Integer>> res, List<Integer> list, int n, int start) {
//        if (n == 1 && list.size() > 1) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = start; i <= n; i++) {
//            if (n % i == 0) {
//                list.add(i);
//                getFactors(res, list, n / i, i);
//                list.remove(list.size() - 1);
//            }
//        }
//    }

    // O(n^1.5)
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getFactors(res, list, n, 2);
        return res;
    }

    public void getFactors(List<List<Integer>> res, List<Integer> list, int n, int start) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                getFactors(res, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
        list.add(n);
        getFactors(res, list, 1, n);
        list.remove(list.size() - 1);
    }

}
