package Leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak2_140 {

    // Bottom up DP - TLE
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        HashSet<String> wordSet = new HashSet<>(wordDict);
//        List<String>[] dp = new ArrayList[s.length()+1];
//        for (int i = 0; i <= s.length(); i++) {
//            dp[i] = new ArrayList<>();
//        }
//        dp[0].add("");
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i+1; j <= s.length(); j++) {
//                List<String> list = new ArrayList<>();
//                String word = s.substring(i, j);
//                if (wordSet.contains(word)) {
//                    for (String str: dp[i]) {
//                        list.add(str.length() == 0? word: str + " " + word);
//                    }
//                    dp[j].addAll(list);
//                }
//            }
//        }
//        return dp[s.length()];
//    }

    // Top down DP with memorization
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        HashMap<String, List<String>> memory = new HashMap<>();
        return wordBreak(s, wordSet, memory);
    }

    public List<String> wordBreak(String s, HashSet<String> wordSet, HashMap<String, List<String>> memory) {
        if (memory.containsKey(s)) {
            return memory.get(s);
        }
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word: wordSet) {
            int len = word.length();
            if (s.length() >= len && word.equals(s.substring(0, len))) {
                List<String> list = wordBreak(s.substring(len), wordSet, memory);
                for (String str: list) {
                    res.add(str.length() == 0? word: word + " " + str);
                }
            }

        }
        memory.put(s, res);
        return res;
    }
}
