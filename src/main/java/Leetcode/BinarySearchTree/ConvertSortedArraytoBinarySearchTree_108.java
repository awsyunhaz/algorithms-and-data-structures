package Leetcode.BinarySearchTree;

public class ConvertSortedArraytoBinarySearchTree_108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int lo, int hi){
        if (lo > hi)
            return null;
        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, lo, mid-1);
        node.right = buildTree(nums, mid+1, hi);
        return node;
    }
}
