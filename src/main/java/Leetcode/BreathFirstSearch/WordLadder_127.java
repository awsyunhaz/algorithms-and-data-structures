package Leetcode.BreathFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder_127 {
    // BFS, brute force compare - O(n^2*l), n: number of words, l: word length
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int step = 0;
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//        while (!queue.isEmpty()) {
//            step ++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String word = queue.poll();
//                if (word.equals(endWord)) {
//                    return step;
//                }
//                int j = 0;
//                while (j < wordList.size()) {
//                    String nextWord = wordList.get(j);
//                    if (isDiffOne(word, nextWord)) {
//                        queue.add(wordList.remove(j));
//                    } else {
//                        j ++;
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//
//    public boolean isDiffOne(String str1, String str2) {
//        int diff = 0;
//        for (int i = 0; i < str1.length(); i++) {
//            if (str1.charAt(i) != str2.charAt(i)) {
//                diff ++;
//            }
//            if (diff > 1) {
//                return false;
//            }
//        }
//        return diff == 1;
//    }

    // BFS, build up next word - O(n*l*26)
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
            }
        }
        return 0;

    }
}
