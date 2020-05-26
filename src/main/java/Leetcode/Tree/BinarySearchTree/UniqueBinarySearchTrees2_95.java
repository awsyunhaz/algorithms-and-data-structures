package Leetcode.Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2_95 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    //Divide and conquer - 2ms
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>();
        return generateTreeBetween(1, n);
    }

    public List<TreeNode> generateTreeBetween(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if (start>end){
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++){
            List<TreeNode> leftTree = generateTreeBetween(start, i-1);
            List<TreeNode> rightTree = generateTreeBetween(i+1, end);

            for (TreeNode l: leftTree){
                for (TreeNode r: rightTree){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
