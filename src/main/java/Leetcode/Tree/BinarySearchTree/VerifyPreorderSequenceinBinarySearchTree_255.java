package Leetcode.Tree.BinarySearchTree;

import java.util.Stack;

public class VerifyPreorderSequenceinBinarySearchTree_255 {
    // O(n^2)
//    public boolean verifyPreorder(int[] preorder) {
//        return verifyPreorder(preorder, 0, preorder.length-1);
//    }
//
//    public boolean verifyPreorder(int[] preorder, int start, int end) {
//        if (start >= end) {
//            return true;
//        }
//
//        int higher = -1;
//        int lowerBound = preorder[start];
//        for (int i = start+1; i <= end; i++) {
//            if (higher != -1 && preorder[i] < lowerBound) {
//                return false;
//            }
//            if (higher == -1 && preorder[i] > preorder[start]) {
//                higher = i;
//            }
//        }
//
//        // no right child, verify left subtree
//        if (higher == -1) {
//            return verifyPreorder(preorder, start+1, end);
//        // verify left and right subtree
//        } else {
//            return verifyPreorder(preorder, start+1, higher-1) && verifyPreorder(preorder, higher, end);
//        }
//    }

    // Stack, O(n)
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int p: preorder) {
            if (p < low) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < p) {
                low = stack.pop();
            }
            stack.push(p);
        }
        return true;
    }
}
