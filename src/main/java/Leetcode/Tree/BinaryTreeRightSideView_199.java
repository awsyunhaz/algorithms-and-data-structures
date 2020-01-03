package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_199 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        visit(res, root, 1);
        return res;
    }

    public void visit(List<Integer> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() < level) {
            res.add(root.val);
        }
        visit(res, root.right, level+1);
        visit(res, root.left, level+1);
    }
}
