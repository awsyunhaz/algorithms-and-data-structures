package leetcode.LinkedList;

public class RemoveLinkedListElements_203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 3ms
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        while (head!=null){
            if (head.val!=val){
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        }
        prev.next = null;
        return dummy.next;

        // Recursion
//        if (head==null)
//            return head;
//        if (head.val==val)
//            return removeElements(head.next, val);
//        else{
//            head.next = removeElements(head.next, val);
//            return head;
//        }
    }
}
