package Leetcode.Tree;

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return search(postorder, postorder.length-1, inorder, 0, postorder.length-1);
    }

    private TreeNode search(int[] postorder, int ind, int[] inorder, int start, int end){
        for (int i=start; i<=end; i++){
            if (postorder[ind]==inorder[i]){
                TreeNode root = new TreeNode(postorder[ind]);
                root.right = search(postorder, ind-1, inorder, i+1, end);
                root.left = search(postorder, ind-(end-i)-1, inorder, start, i-1);
                return root;
            }
        }
        return null;
    }
}
