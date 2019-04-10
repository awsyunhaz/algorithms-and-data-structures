package leetcode.Tree;

public class SymmetricTree_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return isEqual(root.left, root.right);
    }

    private boolean isEqual(TreeNode l, TreeNode r){
        if (l==null && r==null) return true;
        if (l==null || r==null) return false;
        if (l.val != r.val) return false;
        return isEqual(l.left, r.right) && isEqual(l.right, r.left);
    }
}
