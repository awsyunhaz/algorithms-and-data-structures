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

    // pre-order traversal
//    TreeNode lastNode;
//
//    public void flatten(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        TreeNode rightNode = root.right;
//        if (lastNode != null) {
//            lastNode.right = root;
//        }
//        lastNode = root;
//        flatten(root.left);
//        root.left = null;
//        flatten(rightNode);
//    }

    // Iterative solution, O(n)
//    public void flatten(TreeNode root) {
//        while (root != null) {
//            TreeNode left = root.left;
//            if (left != null) {
//                // the rightmost node of left subtree
//                TreeNode rightMost = left;
//                while (rightMost.right != null) {
//                    rightMost = rightMost.right;
//                }
//                rightMost.right = root.right;
//                root.right = left;
//                root.left = null;
//            }
//            root = root.right;
//        }
//    }

    // post-order traversal
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }


}
