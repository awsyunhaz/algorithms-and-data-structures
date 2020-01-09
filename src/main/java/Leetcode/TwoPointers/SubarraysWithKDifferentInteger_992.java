package Leetcode.TwoPointers;

import java.util.HashMap;

public class SubarraysWithKDifferentInteger_992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysAtMostK(A, K) - subarraysAtMostK(A, K-1);
    }

    public int subarraysAtMostK(int[] A, int K) {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            cntMap.put(A[i], cntMap.getOrDefault(A[i], 0) + 1);
            while (cntMap.size() > K) {
                cntMap.put(A[left], cntMap.get(A[left])-1);
                if (cntMap.get(A[left]) == 0) {
                    cntMap.remove(A[left]);
                }
                left ++;
            }
            res += i-left+1;
        }
        return res;
    }
}
