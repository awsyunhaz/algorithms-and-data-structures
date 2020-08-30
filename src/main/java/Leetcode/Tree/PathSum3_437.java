package Leetcode.Tree;

import java.util.HashMap;

public class PathSum3_437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // recursion, O(n^d), d: tree depth
//    public int pathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return 0;
//        }
//        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum) ;
//    }
//
//    public int pathSumFrom(TreeNode root, int sum) {
//        if (root == null) {
//            return 0;
//        }
//        return pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val) + (root.val == sum? 1: 0);
//    }

    // hash map, O(n)
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return pathSum(root, 0, sum, preSum);
    }

    public int pathSum(TreeNode root, int sum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int res = 0;
        if (preSum.containsKey(sum - target)) {
            res += preSum.get(sum - target);
        }
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        res += pathSum(root.left, sum, target, preSum) + pathSum(root.right, sum, target, preSum);
        preSum.put(sum, preSum.get(sum) - 1);
        return res;
    }
}
