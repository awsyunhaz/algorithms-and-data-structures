package Leetcode.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree_545 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        if (root.left != null) {
            traverseLeftBound(res, root.left);
        }
        if (!isLeaf(root)) {
            traverseLeaves(res, root);
        }
        if (root.right != null) {
            traverseRightBound(res, root.right);
        }
        return res;
    }

    public void traverseLeftBound(List<Integer> res, TreeNode node) {
        if (isLeaf(node)) {
            return;
        }
        res.add(node.val);
        if (node.left != null) {
            traverseLeftBound(res, node.left);
        } else {
            traverseLeftBound(res, node.right);
        }
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void traverseLeaves(List<Integer> res, TreeNode node) {
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }
        if (node.left != null) {
            traverseLeaves(res, node.left);
        }
        if (node.right != null) {
            traverseLeaves(res, node.right);
        }
    }

    public void traverseRightBound(List<Integer> res, TreeNode node) {
        if (isLeaf(node)) {
            return;
        }
        if (node.right != null) {
            traverseRightBound(res, node.right);
        } else {
            traverseRightBound(res, node.left);
        }
        res.add(node.val);
    }
}
