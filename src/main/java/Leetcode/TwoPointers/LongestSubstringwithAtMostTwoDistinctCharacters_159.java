package Leetcode.TwoPointers;

import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters_159 {

    // 9ms
//    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        HashMap<Character, Integer> charCnt = new HashMap<>();
//        int lo = 0, hi = 0, res = 0;
//        while (hi < s.length()) {
//            // Add to right
//            while (hi < s.length() && charCnt.size() <= 2) {
//                charCnt.put(s.charAt(hi), charCnt.getOrDefault(s.charAt(hi), 0) + 1);
//                hi ++;
//            }
//            if (charCnt.size() > 2) {
//                res = Math.max(res, hi-lo-1);
//            } else {
//                res = Math.max(res, hi-lo);
//            }
//
//            // Delete from left
//            while (lo < s.length() && charCnt.size() > 2) {
//                if (charCnt.get(s.charAt(lo)) == 1) {
//                    charCnt.remove(s.charAt(lo));
//                } else {
//                    charCnt.put(s.charAt(lo), charCnt.get(s.charAt(lo)) - 1);
//                }
//                lo ++;
//            }
//        }
//        return res;
//    }

    // HashMap to keep the rightest index of a character
    // 8ms
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            indexMap.put(s.charAt(i), i);
            if (indexMap.size() <= 2) {
                res = Math.max(res, i-left+1);
            } else {
                int ind = Integer.MAX_VALUE;
                for (int v: indexMap.values()) {
                    ind = Math.min(ind, v);
                }
                indexMap.remove(s.charAt(ind));
                left = ind + 1;
            }
        }
        return res;
    }
}
