package Leetcode.LinkedList;

public class PlusOneLinkedList_369 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

//    public ListNode plusOne(ListNode head) {
//        head = plus(head);
//        if (head.val == 10) {
//            head.val = 0;
//            ListNode newHead = new ListNode(1);
//            newHead.next = head;
//            return newHead;
//        }
//        return head;
//    }
//
//    public ListNode plus(ListNode head) {
//        if (head.next == null) {
//            head.val ++;
//            return head;
//        }
//        head.next = plus(head.next);
//        if (head.next.val == 10) {
//            head.next.val = 0;
//            head.val ++;
//        }
//        return head;
//    }

    // Shorter implementation
    public ListNode plusOne(ListNode head) {
        if (plus(head) == 1) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        } else {
            return head;
        }
    }

    public int plus(ListNode head) {
        if (head == null) {
            return 1;
        }
        int carry = plus(head.next);
        int val = head.val + carry;
        head.val = val % 10;
        return val / 10;
    }
}
