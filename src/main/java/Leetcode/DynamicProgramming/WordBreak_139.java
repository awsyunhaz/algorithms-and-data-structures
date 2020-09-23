package Leetcode.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class WordBreak_139 {

    // BFS - O(n^2)
//    public boolean wordBreak(String s, List<String> wordDict) {
//        HashSet<String> wordSet = new HashSet<>(wordDict);
//        Queue<Integer> queue = new ArrayDeque<>();
//        boolean[] visited = new boolean[s.length()];
//        queue.offer(0);
//        while (!queue.isEmpty()) {
//            int start = queue.poll();
//            if (start == s.length()) {
//                return true;
//            }
//            if (!visited[start]) {
//                visited[start] = true;
//                for (int end = start+1; end <= s.length(); end++) {
//                    if (wordSet.contains(s.substring(start, end))) {
//                        queue.offer(end);
//                    }
//                }
//            }
//        }
//        return false;
//    }

    // Backtrack with memorization, O(n^2)
//    public boolean wordBreak(String s, List<String> wordDict) {
//        HashSet<String> wordSet = new HashSet<>(wordDict);
//        Boolean[] memory = new Boolean[s.length()];
//        return wordBreak(s, 0, wordSet, memory);
//    }
//
//    public boolean wordBreak(String s, int i, HashSet<String> wordSet, Boolean[] memory) {
//        if (i == s.length()) {
//            return true;
//        }
//        if (memory[i] != null) {
//            return memory[i];
//        }
//        for (int j = i+1; j <= s.length(); j++) {
//            if (wordSet.contains(s.substring(i, j))) {
//                if (wordBreak(s, j, wordSet, memory)) {
//                    memory[i] = true;
//                    return true;
//                }
//            }
//        }
//        memory[i] = false;
//        return false;
//    }

    // DP - O(n^2)
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                // (0, j) can be reached if (0, i) can be reached and (i, j) is in wordDict
                if (wordSet.contains(s.substring(i, j)) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[len];
    }
}
