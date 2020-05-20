package Leetcode.Design;

import java.util.HashSet;

public class AddandSearchWord_211 {

    // hashmap + backtracking, (2^n), TLE
//    HashSet<String> dict;
//
//    /** Initialize your data structure here. */
//    public AddandSearchWord_211() {
//        dict = new HashSet<>();
//    }
//
//    /** Adds a word into the data structure. */
//    public void addWord(String word) {
//        StringBuffer sb = new StringBuffer(word);
//        addExpression(sb, 0);
//    }
//
//    public void addExpression(StringBuffer word, int start) {
//        if (!dict.contains(word.toString())) {
//            dict.add(word.toString());
//            for (int i = start; i < word.length(); i++) {
//                char c = word.charAt(i);
//                word.setCharAt(i, '.');
//                addExpression(word, i+1);
//                word.setCharAt(i, c);
//            }
//        }
//    }
//
//    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//    public boolean search(String word) {
//        return dict.contains(word);
//    }

    // Trie
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public AddandSearchWord_211() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWord(word, 0, root);
    }

    public boolean searchWord(String word, int ind, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (ind == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(ind);
        if (c == '.') {
            for (TrieNode child: node.children) {
                if (searchWord(word, ind+1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return searchWord(word, ind+1, node.children[c - 'a']);
        }
    }
}
