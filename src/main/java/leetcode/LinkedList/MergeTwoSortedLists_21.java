package leetcode.LinkedList;

public class MergeTwoSortedLists_21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Iterative - 5ms
        ListNode head = new ListNode(0), node = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            } else {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }
        if (l1 == null) node.next = l2;
        if (l2 == null) node.next = l1;
        return head.next;
    }

        // Recursion - O(n) 5ms
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        if (l1.val <= l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
}
