package Leetcode.Tree.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordSearch2_212 {
    // DFS, O(B*N*3^L), B: number of board cells, N: number of words, L: word length
//    public List<String> findWords(char[][] board, String[] words) {
//        HashSet<String> res = new HashSet<>();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                for (String word: words) {
//                    if (!res.contains(word) && search(board, i, j, word, 0)) {
//                        res.add(word);
//                    }
//                }
//            }
//        }
//
//        return new ArrayList<>(res);
//    }
//
//    public boolean search(char[][] board, int i, int j, String word, int ind) {
//        if (board[i][j] != word.charAt(ind)) {
//            return false;
//        }
//        if (ind == word.length() - 1) {
//            return true;
//        }
//        char c = board[i][j];
//        board[i][j] = ' ';
//        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//        for (int[] dir: dirs) {
//            int row = i + dir[0], col = j + dir[1];
//            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && search(board, row, col, word, ind+1)) {
//                board[i][j] = c;
//                return true;
//            }
//        }
//        board[i][j] = c;
//        return false;
//    }

    // Trie, O(B*3^L)
    class TrieNode {
        public TrieNode[] children;
        public String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> res = new ArrayList<>();

        for (String word: words) {
            addWord(root, word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                List<String> foundWords = new ArrayList<>();
                search(board, i, j, root, foundWords);
                for (String word: foundWords) {
                    res.add(word);
                }
            }
        }

        return res;
    }

    public void addWord(TrieNode node, String word) {
        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.word = word;
    }


    public void search(char[][] board, int i, int j, TrieNode node, List<String> res) {
        TrieNode child = node.children[board[i][j] - 'a'];
        if (child == null) {
            return;
        }
        if (child.word != null) {
            res.add(child.word);
            // de-duplicate
            child.word = null;
        }

        char c = board[i][j];
        board[i][j] = ' ';
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir: dirs) {
            int row = i + dir[0], col = j + dir[1];
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] != ' ') {
                search(board, row, col, child, res);
            }
        }
        board[i][j] = c;
    }
}
