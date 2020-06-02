package Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 {

    // backtrack, O(n!), TLE
//    public String getPermutation(int n, int k) {
//        List<String> res = new ArrayList<>();
//        StringBuffer sb = new StringBuffer();
//        boolean[] used = new boolean[n+1];
//        permute(res, sb, n, used);
//        return res.get(k-1);
//    }
//
//    public void permute(List<String> res, StringBuffer sb, int n, boolean[] used) {
//        if (sb.length() == n) {
//            res.add(sb.toString());
//            return;
//        }
//        for (int i = 1; i <= n; i++) {
//            if (!used[i]) {
//                used[i] = true;
//                sb.append((char) ('0' + i));
//                permute(res, sb, n, used);
//                sb.deleteCharAt(sb.length()-1);
//                used[i] = false;
//            }
//        }
//    }

    // O(n)
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i*factorial[i-1];
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k --;
        StringBuffer sb = new StringBuffer();
        for (int i = n; i >= 1; i--) {
            int ind = k / factorial[i-1];
            sb.append(nums.get(ind).toString());
            nums.remove(ind);
            k -= ind*factorial[i-1];
        }
        return sb.toString();
    }
}
