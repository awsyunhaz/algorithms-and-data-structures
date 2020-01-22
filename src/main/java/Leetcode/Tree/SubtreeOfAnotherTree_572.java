package Leetcode.Tree;

public class SubtreeOfAnotherTree_572 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        } else if (s != null) {
            if (s.val == t.val && isEqual(s, t)) {
                return true;
            }
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        } else {
            return false;
        }
    }

    public boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s != null && t != null) {
            return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
        } else {
            return false;
        }
    }
}
