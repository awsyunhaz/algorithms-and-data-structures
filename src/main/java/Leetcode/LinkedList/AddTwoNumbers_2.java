package Leetcode.LinkedList;

public class AddTwoNumbers_2 {
    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Iterative solution
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int inc = 0;
        while (l1 != null || l2 != null || inc != 0){
            int num1 = 0, num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = num1 + num2 + inc;
            node.next = new ListNode(sum % 10);
            node = node.next;
            inc = sum / 10;
        }
        return head.next;
    }

    // Recursive solution
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(0);
//        head.next = add(l1, l2, 0);
//        return head.next;
//    }
//
//    public ListNode add(ListNode l1, ListNode l2, int c){
//        if (l1 == null && l2 == null && c == 0){
//            return null;
//        }
//        int v1 = 0, v2 = 0;
//        ListNode n1 = l1, n2 = l2;
//        if (l1 != null) {
//            v1 = l1.val;
//            n1 = l1.next;
//        }
//        if (l2 != null) {
//            v2 = l2.val;
//            n2 = l2.next;
//        }
//        int val = v1 + v2 + c;
//        ListNode node = new ListNode(val % 10);
//        c = val / 10;
//        node.next = add(n1, n2, c);
//        return node;
//    }
}
