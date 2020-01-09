package Leetcode.TwoPointers;

import java.util.HashMap;

public class LongestSubstringwithAtMostKDistinctCharacters_340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            indexMap.put(s.charAt(i), i);
            if (indexMap.size() > k) {
                int ind = Integer.MAX_VALUE;
                for (int pos: indexMap.values()) {
                    ind = Math.min(ind, pos);
                }
                indexMap.remove(s.charAt(ind));
                left = ind + 1;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}
