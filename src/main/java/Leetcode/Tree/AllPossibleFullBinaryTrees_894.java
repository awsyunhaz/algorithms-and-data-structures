package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees_894 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (N % 2 == 0) {
            return res;
        }
        for (int i = 1; i + 2 <= N; i+=2) {
            List<TreeNode> leftSubtrees = allPossibleFBT(i);
            List<TreeNode> rightSubtrees = allPossibleFBT(N-i-1);
            for (TreeNode leftChild: leftSubtrees) {
                for (TreeNode rightChild: rightSubtrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftChild;
                    root.right = rightChild;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
