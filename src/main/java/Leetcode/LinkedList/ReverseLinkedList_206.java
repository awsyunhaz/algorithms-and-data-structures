package Leetcode.LinkedList;

import java.util.Stack;

public class ReverseLinkedList_206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            ListNode succ = fast.next;
            fast.next = slow;
            slow = fast;
            fast = succ;
        }
        dummy.next.next = null;
        dummy.next = slow;
        return dummy.next;
    }

    // Stack
//    public ListNode reverseList(ListNode head) {
//        if (head == null)
//            return null;
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//        ListNode newHead = stack.pop();
//        ListNode node = newHead;
//        while (!stack.isEmpty()) {
//            node.next = stack.pop();
//            node = node.next;
//        }
//        node.next = null;
//        return newHead;
//    }
}
