package Leetcode.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree_109 {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Definition for a binary tree node.
     **/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Convert to array list
//    public TreeNode sortedListToBST(ListNode head) {
//        List<ListNode> nums = new ArrayList<>();
//        while (head != null) {
//            nums.add(head);
//            head = head.next;
//        }
//        return buildBST(nums, 0, nums.size()-1);
//    }
//
//
//    public TreeNode buildBST(List<ListNode> nums, int start, int end) {
//        if (start > end) {
//            return null;
//        }
//        int mid = (start + end) / 2;
//        TreeNode root = new TreeNode(nums.get(mid).val);
//        root.left = buildBST(nums, start, mid-1);
//        root.right = buildBST(nums, mid+1, end);
//        return root;
//    }

    // Two pointer
    // end is always the next of last node
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head, null);
    }

    public TreeNode buildBST(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(start, slow);
        root.right = buildBST(slow.next, end);
        return root;
    }
}
