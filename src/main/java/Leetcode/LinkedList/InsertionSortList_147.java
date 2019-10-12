package Leetcode.LinkedList;

public class InsertionSortList_147 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//    public ListNode insertionSortList(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode insertPrev = head;
//        while (insertPrev.next != null) {
//            ListNode insert = insertPrev.next;
//            ListNode comparePrev = dummy;
//            while (comparePrev.next != insert && insert.val > comparePrev.next.val) {
//                comparePrev = comparePrev.next;
//            }
//            if (insertPrev != comparePrev) {
//                insertPrev.next = insertPrev.next.next;
//                insert.next = comparePrev.next;
//                comparePrev.next = insert;
//            } else {
//                insertPrev = insertPrev.next;
//            }
//        }
//        return dummy.next;
//    }

    // Reconstruct a new linked list
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            ListNode comparePrev = dummy;
            while (comparePrev.next != null && curr.val > comparePrev.next.val) {
                comparePrev = comparePrev.next;
            }
            curr.next = comparePrev.next;
            comparePrev.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}
