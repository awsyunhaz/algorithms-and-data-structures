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
        // Recursion - 5ms
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

        // 6ms
//        ListNode head = new ListNode(0);
//        ListNode node = head;
//        while (l1!=null && l2!=null){
//            if (l1.val<=l2.val){
//                node.next = new ListNode(l1.val);
//                node = node.next;
//                l1 = l1.next;
//            }
//            else{
//                node.next = new ListNode(l2.val);
//                node = node.next;
//                l2 = l2.next;
//            }
//        }
//        while (l1!=null){
//            node.next = new ListNode(l1.val);
//            node = node.next;
//            l1 = l1.next;
//        }
//        while (l2!=null){
//            node.next = new ListNode(l2.val);
//            node = node.next;
//            l2 = l2.next;
//        }
//        return head.next;
//    }
}
