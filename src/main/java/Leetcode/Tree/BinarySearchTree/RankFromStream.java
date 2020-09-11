package Leetcode.Tree.BinarySearchTree;

import java.util.Arrays;
import java.util.List;

public class RankFromStream {
    public class TreeNode {
        TreeNode left, right;
        int val, count, leftSize;

        public TreeNode (int val) {
            this.val = val;
            count = 1;
            leftSize = 0;
        }
    }

    private TreeNode root;

    public void track(int x) {
        root = add(root, x);
    }

    public TreeNode add(TreeNode root, int x) {
        if (root == null) {
            return new TreeNode(x);
        } else {
            if (x == root.val) {
                root.count ++;
            } else if (x < root.val) {
                root.leftSize ++;
                root.left = add(root.left, x);
            } else {
                root.right = add(root.right, x);
            }
        }
        return root;
    }

    public int getRankOfNumber(int x) {
        return getRank(root, x) - 1;
    }

    public int getRank(TreeNode root, int x) {
        if (root.val == x) {
            return root.leftSize + root.count;
        } else if (x < root.val) {
            return getRank(root.left, x);
        } else {
            return root.count + getRank(root.right, x);
        }
    }

    public static void main(String[] args) {
        RankFromStream obj = new RankFromStream();
        int[] arr = new int[]{5, 1, 4, 4, 5, 9, 7, 13, 3};
        for (int num: arr) {
            obj.track(num);
        }
        System.out.println(obj.getRankOfNumber(1));
        System.out.println(obj.getRankOfNumber(3));
        System.out.println(obj.getRankOfNumber(4));
    }
}
