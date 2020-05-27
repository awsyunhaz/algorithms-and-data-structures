package Leetcode.Tree.BinarySearchTree;

public class SerializeAndDeserializeBST_449 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preOrderTraverse(root, sb);
        return sb.toString();
    }

    public void preOrderTraverse(TreeNode root, StringBuffer sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        sb.append(",");
        preOrderTraverse(root.left, sb);
        preOrderTraverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        int[] vals = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            vals[i] = Integer.parseInt(strs[i]);
        }
        TreeNode root = buildTree(vals, 0, strs.length-1);
        return root;
    }

    public TreeNode buildTree(int[] vals, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(vals[start]);
        if (start == end) {
            return root;
        }
        int i = start+1;
        while (i <= end && vals[i] < vals[start]) i++;
        root.left = buildTree(vals, start+1, i-1);
        root.right = buildTree(vals, i, end);
        return root;
    }
}
