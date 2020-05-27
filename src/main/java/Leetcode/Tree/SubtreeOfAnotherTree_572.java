package Leetcode.Tree;

public class SubtreeOfAnotherTree_572 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }
        return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t != null) {
            return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
        }
        return false;
    }
}
