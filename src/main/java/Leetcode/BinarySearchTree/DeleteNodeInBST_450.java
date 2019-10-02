package Leetcode.BinarySearchTree;

public class DeleteNodeInBST_450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else{
            if (root.right == null)
                return root.left;
            else {
                TreeNode minNode = findMin(root.right);
                minNode.right = deleteNode(root.right, minNode.val);
                minNode.left = root.left;
                return minNode;
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        if (root == null)
            return null;
        while(root.left != null)
            root = root.left;
        return root;
    }
}
