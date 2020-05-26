package Leetcode.Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessorInBST_285 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // inorder traverse
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        List<TreeNode> res = new ArrayList<>();
//        inorderTraverse(root, res);
//        for (int i = 0; i < res.size(); i++) {
//            if (res.get(i) == p) {
//                if (i < res.size() - 1) {
//                    return res.get(i+1);
//                } else {
//                    return null;
//                }
//            }
//        }
//        return null;
//    }
//
//    public void inorderTraverse(TreeNode root, List<TreeNode> res) {
//        if (root == null) {
//            return;
//        }
//        inorderTraverse(root.left, res);
//        res.add(root);
//        inorderTraverse(root.right, res);
//    }

    // global flag
//    private boolean flag;
//
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        flag = false;
//        return inorderTraverse(root, p);
//    }
//
//    public TreeNode inorderTraverse(TreeNode node, TreeNode p) {
//        if (node == null) {
//            return null;
//        }
//        TreeNode left = inorderTraverse(node.left, p);
//        // go left
//        if (left != null) {
//            return left;
//        }
//        if (flag) {
//            return node;
//        }
//        if (node == p) {
//            flag = true;
//        }
//        // go right
//        TreeNode right = inorderTraverse(node.right, p);
//        if (right != null) {
//            return right;
//        }
//        return null;
//    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }
        TreeNode last = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                // current value is too small: go left
                // the current value may be the answer
                last = root;
                root = root.left;
            }
        }
        return last;
    }
}
