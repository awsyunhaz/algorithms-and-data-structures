package Leetcode.BinarySearchTree;

import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf_315 {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] counts = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], 0, counts, i);
        }
        return Arrays.asList(counts);
    }

    public Node insert(Node root, int val, int cnt, Integer[] counts, int i) {
        if (root == null) {
            counts[i] = cnt;
            return new Node(val, 0);
        }
        if (val == root.val) {
            root.dup ++;
            counts[i] = cnt + root.cnt;
        } else if (val < root.val) {
            root.cnt ++;
            root.left = insert(root.left, val, cnt, counts, i);
        } else {
            root.right = insert(root.right, val, cnt+root.cnt+root.dup, counts, i);
        }
        return root;
    }

    class Node {
        int cnt, dup, val;
        Node left, right;
        public Node (int v, int c){
            cnt = c;
            dup = 1;
            val = v;
        }
    }
}
