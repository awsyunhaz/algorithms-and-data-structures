package Leetcode.Tree.Trie;

import java.util.HashMap;

public class LongestCommonPrefix_14 {
    class TrieNode{
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        int common = Integer.MAX_VALUE;
        if (strs.length == 0)
            return "";
        insert(root, strs[0]);
        for (String str: strs) {
            common = Math.min(common, search(root, str));
            insert(root, str);
        }
        return strs[0].substring(0, common);
    }

    public void insert(TrieNode root, String str) {
        for (char c: str.toCharArray()) {
            if (!root.children.containsKey(c)) {
                TrieNode node = new TrieNode();
                root.children.put(c, node);
            }
            root = root.children.get(c);
        }
        root.isEnd = true;
    }

    public int search(TrieNode root, String str) {
        int len = 0;
        for (char c: str.toCharArray()) {
            if (root.isEnd || !root.children.containsKey(c)) {
                return len;
            }
            else {
                TrieNode node = root.children.get(c);
                root = node;
                len ++;
            }
        }
        return len;
    }
}
