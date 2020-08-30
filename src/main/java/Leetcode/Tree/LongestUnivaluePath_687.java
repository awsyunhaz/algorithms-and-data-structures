package Leetcode.Tree;

public class LongestUnivaluePath_687 {
    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // O(nlogn)
//    public int longestUnivaluePath(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftDepth = depth(root.left, root.val);
//        int rightDepth = depth(root.right, root.val);
//        return Math.max(Math.max(leftDepth + rightDepth, longestUnivaluePath(root.left)), longestUnivaluePath(root.right));
//    }
//
//    public int depth(TreeNode root, int val) {
//        if (root == null || root.val != val) {
//            return 0;
//        }
//        return Math.max(depth(root.left, val), depth(root.right, val)) + 1;
//    }

    // O(n)
    private int maxLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestPath(root, root.val);
        return maxLen;
    }

    public int longestPath(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int leftDepth = longestPath(root.left, root.val);
        int rightDepth = longestPath(root.right, root.val);
        maxLen = Math.max(maxLen, leftDepth + rightDepth);
        // this node equals to parent node
        if (root.val == val) {
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return 0;
    }
}
