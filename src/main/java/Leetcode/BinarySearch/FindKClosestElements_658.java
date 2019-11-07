package Leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        while (hi - lo + 1 > k) {
            if (arr[hi] - x >= x - arr[lo]) {
                hi --;
            } else {
                lo ++;
            }
        }
        for (int i = lo; i <= hi; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
