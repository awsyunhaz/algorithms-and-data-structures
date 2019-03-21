package leetcode.LinkedList;

public class PalindromeLinkedList_234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head==null)
            return true;
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = reverse(slow);
        while (head!=null && node!=null){
            if (head.val!=node.val)
                return false;
            head = head.next;
            node = node.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node){
        ListNode prev = node, succ = node.next;
        node.next = null;
        while(succ!=null){
            node = succ;
            succ = succ.next;
            node.next = prev;
            prev = node;
        }
        return node;
    }
}
