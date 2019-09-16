package Leetcode.Tree;

public class SecondMinimumNodeInaBinaryTree_671 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // DFS
//    private long res;
//    private int minVal;
//
//    public int findSecondMinimumValue(TreeNode root) {
//        if (root == null) return -1;
//        res = Long.MAX_VALUE;
//        minVal = root.val;
//        search(root);
//        return res == Long.MAX_VALUE? -1: (int)res;
//    }
//
//    public void search(TreeNode root){
//        if (root == null)
//            return;
//        if (root.val > minVal){
//            if (root.val < res)
//                res = root.val;
//            return;
//        }
//        else{
//            search(root.left);
//            search(root.right);
//        }
//    }

    // Recursive
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null)
            return -1;
        int left = root.val == root.left.val? findSecondMinimumValue(root.left): root.left.val;
        int right = root.val == root.right.val? findSecondMinimumValue(root.right): root.right.val;
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
}
