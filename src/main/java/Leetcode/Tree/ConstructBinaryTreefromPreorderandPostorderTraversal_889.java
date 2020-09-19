package Leetcode.Tree;

public class ConstructBinaryTreefromPreorderandPostorderTraversal_889 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, pre.length-1, 0);
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int postEnd = postStart;
        while (postEnd < post.length && post[postEnd] != pre[preStart+1]) {
            postEnd++;
        }
        int count = postEnd - postStart + 1;
        root.left = constructFromPrePost(pre, post, preStart + 1, preStart + count, postStart);
        root.right = constructFromPrePost(pre, post, preStart + count + 1, preEnd, postStart + count);
        return root;
    }
}
