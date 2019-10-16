package Leetcode.Trie;

import java.util.*;

public class LongestWordInDictionary_720 {

    // Sort string array by alphabetical order
    public String longestWord(String[] words) {
        String res = "";
        HashSet<String> set = new HashSet<>();
        set.add("");
        Arrays.sort(words);
        for (String word: words) {
            String preWord = word.substring(0, word.length()-1);
            if (set.contains(preWord)) {
                if (word.length() > res.length())
                    res = word;
                set.add(word);
            }
        }
        return res;
    }

    // Trie - 21ms
//    private String res;
//
//    class TrieNode {
//        HashMap<Character, TrieNode> children;
//        boolean isEnd;
//
//        public TrieNode() {
//            children = new HashMap<>();
//            isEnd = false;
//        }
//    }
//
//    public void insert(TrieNode root, String str) {
//        for (char c: str.toCharArray()) {
//            if (!root.children.containsKey(c)) {
//                root.children.put(c, new TrieNode());
//            }
//            root = root.children.get(c);
//        }
//        root.isEnd = true;
//    }
//
//    public void search(TrieNode root, StringBuffer curr) {
//        List<Character> chs = new ArrayList(root.children.keySet());
//        Collections.sort(chs);
//        for (char c: chs) {
//            TrieNode child = root.children.get(c);
//            if (child.isEnd) {
//                curr.append(c);
//                if (curr.length() > res.length()) {
//                    res = curr.toString();
//                }
//                search(child, curr);
//                curr.deleteCharAt(curr.length()-1);
//            }
//        }
//    }
//
//    public String longestWord(String[] words) {
//        TrieNode root = new TrieNode();
//        res = "";
//
//        for (String str: words) {
//            insert(root, str);
//        }
//
//        search(root, new StringBuffer());
//        return res;
//    }
}
