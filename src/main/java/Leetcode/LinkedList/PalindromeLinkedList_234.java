package Leetcode.LinkedList;

import java.util.Stack;

public class PalindromeLinkedList_234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Stack - O(n) space
//    public boolean isPalindrome(ListNode head) {
//        ListNode node = head;
//        int len = 0;
//        while (node != null) {
//            node = node.next;
//            len ++;
//        }
//        Stack<Integer> stack = new Stack<>();
//        node = head;
//        for (int i = 0; i < len/2; i++) {
//            stack.push(node.val);
//            node = node.next;
//        }
//        if (len % 2 == 1) {
//            node = node.next;
//        }
//        for (int i = 0; i < len/2; i++) {
//            if (node.val != stack.pop()) {
//                return false;
//            }
//            node = node.next;
//        }
//        return true;
//    }

    // reverse the second half - O(1) space
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
