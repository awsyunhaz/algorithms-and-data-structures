package Leetcode.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest_1110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> delete_set = new HashSet();
        for (int num: to_delete) {
            delete_set.add(num);
        }
        if (root == null) {
            forest.add(root);
            return forest;
        }
        if (!delete_set.contains(root.val)) {
            forest.add(root);
        }
        delNodes(root, forest, delete_set);
        return forest;
    }

    public TreeNode delNodes(TreeNode root, List<TreeNode> forest, Set<Integer> delete_set) {
        if (root == null) {
            return null;
        }
        root.left = delNodes(root.left, forest, delete_set);
        root.right = delNodes(root.right, forest, delete_set);
        if (delete_set.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }
            if (root.right != null) {
                forest.add(root.right);
            }
            return null;
        }
        return root;
    }
}
