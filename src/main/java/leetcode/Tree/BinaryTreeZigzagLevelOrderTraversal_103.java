package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(res, root, 0);
        return res;
    }

    private void traverse(List<List<Integer>> res, TreeNode root, int level){
        if (root==null) return;
        if (level>=res.size()) res.add(new ArrayList<Integer>());
        if (level%2==0)
            res.get(level).add(root.val);
        else
            res.get(level).add(0, root.val);
        traverse(res, root.left, level+1);
        traverse(res, root.right, level+1);
    }
}
