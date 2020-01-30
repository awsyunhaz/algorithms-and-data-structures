package Leetcode.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordSearch2_212 {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    TrieNode nextNode = new TrieNode();
                    node.children.put(c, nextNode);
                }
                node = node.children.get(c);
            }
            node.isEnd = true;
        }

        boolean search(String word) {
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    return false;
                }
            }
            return node.isEnd;
        }

        boolean startsWith(String word) {
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res = new HashSet<>();
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuffer sb = new StringBuffer();
                dfs(board, i, j, trie, res, sb);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int i, int j, Trie trie, HashSet<String> res, StringBuffer sb) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || !trie.startsWith(sb.toString())) {
            return;
        }
        char c = board[i][j];
        board[i][j] = ' ';
        sb.append(c);
        if (trie.search(sb.toString())) {
            res.add(sb.toString());
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir: dirs) {
            dfs(board, i+dir[0], j+dir[1], trie, res, sb);
        }
        board[i][j] = c;
        sb.deleteCharAt(sb.length()-1);
    }
}
