package Leetcode.Tree;

public class LowestCommonAncestorofaBinarySearchTree_235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            if (root.val - p.val > 0)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }
}
