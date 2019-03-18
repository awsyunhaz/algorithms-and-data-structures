package leetcode.DivideandConquer;

public class MergekSortedLists_23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    private ListNode partition (ListNode[] lists, int start, int end){
        if (start<end){
            int mid = start + (end-start)/2;
            ListNode l1, l2;
            l1 = partition(lists, start, mid);
            l2 = partition(lists, mid+1, end);
            return merge(l1, l2);
        }
        if (start==end)
            return lists[start];
        else
            return null;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        // Divide and Conquer
        // O(nlogk), k: no of LinkedList - 5ms
        return partition(lists, 0, lists.length-1);

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
    }
}
