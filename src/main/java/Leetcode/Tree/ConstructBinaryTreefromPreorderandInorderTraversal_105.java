package Leetcode.Tree;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return search(preorder, 0, inorder, 0, preorder.length-1);
    }

    private TreeNode search(int[] preorder, int ind, int[] inorder, int start, int end){
        for (int i=start; i<=end; i++){
            if (preorder[ind]==inorder[i]){
                TreeNode root = new TreeNode(preorder[ind]);
                root.left = search(preorder, ind+1, inorder, start, i-1);
                root.right = search(preorder, ind+i-start+1, inorder, i+1, end);
                return root;
            }
        }
        return null;
    }

    // Another implementation
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return build(preorder, inorder, 0, 0, preorder.length-1);
//    }
//
//    public TreeNode build(int[] preorder, int[] inorder, int rootInd, int leftInd, int rightInd) {
//        if (rootInd == preorder.length || leftInd > rightInd) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[rootInd]);
//        int i = leftInd;
//        while (i < rightInd && inorder[i] != preorder[rootInd]) { i++; }
//        root.left = build(preorder, inorder, rootInd+1, leftInd, i-1);
//        root.right = build(preorder, inorder, rootInd+i-leftInd+1, i+1, rightInd);
//        return root;
//    }
}
