package Leetcode.TwoPointers;

import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> charCnt = new HashMap<>();
        int lo = 0, hi = 0, res = 0;
        while (hi < s.length()) {
            while (hi < s.length() && charCnt.size() <= 2) {
                charCnt.put(s.charAt(hi), charCnt.getOrDefault(s.charAt(hi), 0) + 1);
                hi ++;
            }
            if (charCnt.size() > 2) {
                res = Math.max(res, hi-lo-1);
            } else {
                res = Math.max(res, hi-lo);
            }

            while (lo < s.length() && charCnt.size() > 2) {
                if (charCnt.get(s.charAt(lo)) == 1) {
                    charCnt.remove(s.charAt(lo));
                } else {
                    charCnt.put(s.charAt(lo), charCnt.get(s.charAt(lo)) - 1);
                }
                lo ++;
            }
        }
        return res;
    }
}
