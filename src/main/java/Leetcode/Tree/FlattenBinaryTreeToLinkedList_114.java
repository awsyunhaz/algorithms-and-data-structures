package Leetcode.Tree;

public class FlattenBinaryTreeToLinkedList_114 {
    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    TreeNode lastNode;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode rightNode = root.right;
        if (lastNode != null) {
            lastNode.right = root;
        }
        lastNode = root;
        flatten(root.left);
        root.left = null;
        flatten(rightNode);
    }
}
