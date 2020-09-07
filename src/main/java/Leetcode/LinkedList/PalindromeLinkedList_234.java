package Leetcode.LinkedList;

import java.util.Stack;

public class PalindromeLinkedList_234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Stack - O(n) space
//    public boolean isPalindrome(ListNode head) {
//        ListNode fast = head, slow = head;
//        Stack<Integer> stack = new Stack<>();
//        while (fast != null && fast.next != null){
//            stack.push(slow.val);
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        if (fast != null) {
//            slow = slow.next;
//        }
//        while (slow != null) {
//            if (slow.val != stack.pop()) {
//                return false;
//            }
//            slow = slow.next;
//        }
//        return true;
//    }

    // reverse the second half - O(1) space
//    public boolean isPalindrome(ListNode head) {
//        if (head == null)
//            return true;
//        ListNode fast = head, slow = head;
//        while (fast != null && fast.next != null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        ListNode node = reverse(slow);
//        while (head != null && node != null){
//            if (head.val != node.val)
//                return false;
//            head = head.next;
//            node = node.next;
//        }
//        return true;
//    }
//
//    private ListNode reverse(ListNode node){
//        ListNode prev = null;
//        while (node != null) {
//            ListNode next = node.next;
//            node.next = prev;
//            prev = node;
//            node = next;
//        }
//        return prev;
//    }

    // reverse the first half
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head, last = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = last;
            last = slow;
            slow = next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != last.val) {
                return false;
            }
            slow = slow.next;
            last = last.next;
        }
        return true;
    }
}
