package Leetcode.DynamicProgramming;

public class HouseRobber3_337 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int[] val = new int[2];
        val[1] = left[0] + right[0] + root.val;
        val[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return val;
    }
}
