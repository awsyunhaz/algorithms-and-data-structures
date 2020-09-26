package Leetcode.BreathFirstSearch;

import java.util.*;

public class WordLadder2_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashMap<String, List<String>> parentMap = new HashMap<>();
        parentMap.put(beginWord, new ArrayList<>());
        while (!queue.isEmpty()) {
            int size = queue.size();
            HashMap<String, List<String>> localMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // build up new word
                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String nextWord = word.substring(0, j) + c + word.substring(j + 1);
                        if (!parentMap.containsKey(nextWord) && wordSet.contains(nextWord)) {
                            List<String> parents = localMap.getOrDefault(nextWord, new ArrayList<>());
                            parents.add(word);
                            if (!localMap.containsKey(nextWord)) {
                                queue.add(nextWord);
                            }
                            localMap.put(nextWord, parents);
                        }
                    }
                }
            }
            parentMap.putAll(localMap);
        }

        List<List<String>> res = new ArrayList<>();
        if (!parentMap.containsKey(endWord)) {
            return res;
        }
        return getPath(endWord, beginWord, parentMap);
    }

    public List<List<String>> getPath(String word, String beginWord, HashMap<String, List<String>> parentMap) {
        List<List<String>> res = new ArrayList<>();
        if (word.equals(beginWord)) {
            res.add(Arrays.asList(beginWord));
            return res;
        }
        for (String parent: parentMap.get(word)) {
            // get path before word
            List<List<String>> paths = getPath(parent, beginWord, parentMap);
            for (List<String> p: paths) {
                List<String> newPath = new ArrayList<>();
                newPath.addAll(p);
                newPath.add(word);
                res.add(newPath);
            }
        }
        return res;
    }
}
