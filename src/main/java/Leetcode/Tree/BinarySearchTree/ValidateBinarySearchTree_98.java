package Leetcode.Tree.BinarySearchTree;

public class ValidateBinarySearchTree_98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // in order traversal -> ascending order
//    public boolean isValidBST(TreeNode root) {
//        List<Integer> lis = new ArrayList<>();
//        traverse(root, lis);
//        for (int i = 0; i < lis.size()-1; i++) {
//            if (lis.get(i) >= lis.get(i+1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void traverse(TreeNode root, List<Integer> lis) {
//        if (root == null) {
//            return;
//        }
//        traverse(root.left, lis);
//        lis.add(root.val);
//        traverse(root.right, lis);
//    }

    // Use Integer object
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer lowBound, Integer highBound) {
        if (root == null) {
            return true;
        }
        if ((lowBound != null && root.val <= lowBound) || (highBound != null && root.val >= highBound)) {
            return false;
        }
        return validate(root.left, lowBound, root.val) && validate(root.right, root.val, highBound);
    }
}
