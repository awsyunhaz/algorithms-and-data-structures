package Leetcode.LinkedList;

public class RotateList_61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Two pointer, 6ms
//    public ListNode rotateRight(ListNode head, int k) {
//        if (head==null)
//            return head;
//        ListNode fast = head, slow = head;
//        int size = 0;
//        while (fast!=null){
//            size++;
//            fast = fast.next;
//        }
//        fast = head;
//        for (int i=0; i<k%size; i++)
//            fast = fast.next;
//        while (fast.next!=null){
//            fast = fast.next;
//            slow = slow.next;
//        }
//        fast.next = head;
//        head = slow.next;
//        slow.next = null;
//        return head;
//    }

    // Dummy head - 6ms
//    public ListNode rotateRight(ListNode head, int k) {
//        if (head==null)
//            return null;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode fast = dummy, slow = dummy;
//        int size = 0;
//        while (fast.next!=null){
//            size++;
//            fast = fast.next;
//        }
//        for (int i = 0; i < size-k%size; i++)
//            slow = slow.next;
//        fast.next = dummy.next;
//        dummy.next = slow.next;
//        slow.next = null;
//        return dummy.next;
//    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            len ++;
        }
        node.next = head;
        for (int i = 0; i < len - k%len; i++) {
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }
}
