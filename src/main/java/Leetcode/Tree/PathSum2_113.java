package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2_113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        search(res, curr, root, sum);
        return res;
    }

    public void search(List<List<Integer>> res, List<Integer> curr, TreeNode root, int sum){
        if (root == null)
            return;
        curr.add(root.val);
        if (root.left == null && root.right == null && sum == root.val){
            res.add(new ArrayList<>(curr));
        }
        search(res, curr, root.left, sum-root.val);
        search(res, curr, root.right, sum-root.val);
        curr.remove(curr.size()-1);
    }
}
