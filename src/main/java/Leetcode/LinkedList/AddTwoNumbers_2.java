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
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(0);
//        ListNode node = head;
//        int inc = 0;
//        while (l1 != null || l2 != null || inc != 0){
//            int num1 = 0, num2 = 0;
//            if (l1 != null) {
//                num1 = l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                num2 = l2.val;
//                l2 = l2.next;
//            }
//            int sum = num1 + num2 + inc;
//            node.next = new ListNode(sum % 10);
//            node = node.next;
//            inc = sum / 10;
//        }
//        return head.next;
//    }

    // Recursive solution
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int c){
        if (l1 == null && l2 == null && c == 0) {
            return null;
        }
        int num1 = 0, num2 = 0;
        if (l1 != null) {
            num1 = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            num2 = l2.val;
            l2 = l2.next;
        }
        int num = num1 + num2 + c;
        ListNode node = new ListNode(num % 10);
        node.next = add(l1, l2, num/10);
        return node;
    }
}
