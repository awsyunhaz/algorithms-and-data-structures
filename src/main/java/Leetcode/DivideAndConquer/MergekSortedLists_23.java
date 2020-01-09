package Leetcode.DivideAndConquer;

public class MergekSortedLists_23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Divide and Conquer
    // O(nlogk), k: no of LinkedList - 5ms
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = (lo + hi) / 2;
        ListNode l1 = partition(lists, lo, mid);
        ListNode l2 = partition(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}

        // O(kn) - 243ms
//        ListNode head = new ListNode(0);
//        ListNode curr = head;
//        while (true){
//            int min = Integer.MAX_VALUE;
//            boolean finish = true;
//            int id = 0;
//            for (int i = 0; i < lists.length; i++){
//                if (lists[i]!=null){
//                    finish = false;
//                    if (lists[i].val < min){
//                        min = lists[i].val;
//                        id = i;
//                    }
//                }
//            }
//            if (finish)
//                break;
//            curr.next = new ListNode(lists[id].val);
//            curr = curr.next;
//            lists[id] = lists[id].next;
//        }
//        return head.next;
