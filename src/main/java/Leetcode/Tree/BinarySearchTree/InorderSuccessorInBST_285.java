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

    // inorder traversal
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

    // global variable
//    private TreeNode lastNode = null;
//    private TreeNode resNode = null;
//
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if (root == null) {
//            return null;
//        }
//        inorderSuccessor(root.left, p);
//        if (lastNode == p) {
//            resNode = root;
//        }
//        lastNode = root;
//        inorderSuccessor(root.right, p);
//        return resNode;
//    }

    // iterative solution
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if (root == null) {
//            return root;
//        }
//        TreeNode last = null;
//        while (root != null) {
//            if (root.val <= p.val) {
//                root = root.right;
//            } else {
//                // current node is too large: go left
//                // the current value may be the final answer
//                last = root;
//                root = root.left;
//            }
//        }
//        return last;
//    }


    // recursive solution
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        // too small: go right; equals: go right and find the next largest
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode node = inorderSuccessor(root.left, p);
            // if null, the current node is the final answer
            return node == null? root : node;
        }
    }
}
