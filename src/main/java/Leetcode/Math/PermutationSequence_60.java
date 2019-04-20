package Leetcode.Math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] permute = new int[n+1];
        int permuteNum = 1;
        for (int i = 1; i <= n; i++){
            nums.add(i);
            permute[i] = permuteNum *= i;
        }
        StringBuffer sb = new StringBuffer();
        k--;
        for (int i = n-1; i >= 1; i--){
            int ind = k / permute[i];
            sb.append(nums.get(ind));
            nums.remove(ind);
            k -= ind * permute[i];
        }
        sb.append(nums.get(0));
        return sb.toString();
    }
}
