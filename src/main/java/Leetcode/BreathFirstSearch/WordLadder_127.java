package Leetcode.BreathFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder_127 {
    // BFS,brute force compare - 119ms (q*l*n)
    // BFS, hashset - 63ms O(q*l*26)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            while (size-- > 0){
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++){
                    for (char c = 'a'; c < 'z'; c++){
                        char[] chs = word.toCharArray();
                        chs[i] = c;
                        String nextWord = new String(chs);
                        if (set.contains(nextWord)){
                            if (nextWord.equals(endWord))
                                return step;
                            queue.offer(nextWord);
                            set.remove(nextWord);
                        }
                    }
                }
                // while (i < wordList.size()){
                //     String s2 = wordList.get(i);
                //     if (isNeighbor(s1, s2)){
                //         if (s2.equals(endWord)) return step;
                //         queue.offer(wordList.remove(i));
                //     } else{
                //         i++;
                //     }
                // }
            }
        }
        return 0;

    }

//    private boolean isNeighbor(String s1, String s2){
//        int diff = 0;
//        for (int i = 0; i < s1.length(); i++){
//            if (s1.charAt(i) != s2.charAt(i)) diff++;
//            if (diff > 1) return false;
//        }
//        return true;
//    }
}
