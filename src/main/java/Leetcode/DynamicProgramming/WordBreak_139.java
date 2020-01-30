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

    // DP - O(n^2)
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                // If we can reach start and (start, end) is in dictionary, we can reach end
                if (dp[start] && wordDict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                };
            }
        }
        return dp[s.length()];
    }
}
