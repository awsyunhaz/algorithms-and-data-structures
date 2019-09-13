package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree_366 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        getDepth(res, root);
        return res;
    }

    private int getDepth(List<List<Integer>> res, TreeNode root){
        if (root == null)
            return 0;
        int depth = Math.max(getDepth(res, root.left), getDepth(res, root.right)) + 1;
        if (res.size() < depth)
            res.add(new ArrayList<>());
        res.get(depth-1).add(root.val);
        return depth;
    }
}
