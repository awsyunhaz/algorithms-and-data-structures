package Leetcode.Tree.BinarySearchTree;

public class InsertIntoABinarySearchTree_701 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else if (val > root.val)
            root.right = insertIntoBST(root.right, val);
        return root;
    }
}
