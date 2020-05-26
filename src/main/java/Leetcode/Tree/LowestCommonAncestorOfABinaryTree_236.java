package Leetcode.Tree;

public class LowestCommonAncestorOfABinaryTree_236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encoding
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        String strP = encode(root, p, "");
//        String strQ = encode(root, q, "");
//        int ind = 0;
//        while (ind != strP.length() && ind != strQ.length() && strP.charAt(ind) == strQ.charAt(ind)) {
//            if (strP.charAt(ind) == '0') {
//                root = root.left;
//            } else {
//                root = root.right;
//            }
//            ind ++;
//        }
//        return root;
//    }
//
//    public String encode(TreeNode root, TreeNode target, String curr) {
//        if (root == null) {
//            return null;
//        }
//        if (root == target) {
//            return curr;
//        }
//        String l = encode(root.left, target, curr + "0");
//        if (l != null) {
//            return l;
//        }
//        String r = encode(root.right, target, curr + "1");
//        if (r != null) {
//            return r;
//        }
//        return null;
//    }

    // Recursive - Backtrack the LCA node
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
