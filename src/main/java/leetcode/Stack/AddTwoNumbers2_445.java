package leetcode.Stack;

import java.util.Stack;

public class AddTwoNumbers2_445 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Stack - 24ms
        Stack<ListNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        while (l1!=null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2!=null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode prev = null;
        int carry = 0;
        while (!stack1.empty() || !stack2.empty() || carry!=0){
            int num1 = 0, num2 = 0;
            if (!stack1.empty()) num1 = stack1.pop().val;
            if (!stack2.empty()) num2 = stack2.pop().val;
            int res = num1 + num2 + carry;
            ListNode node = new ListNode(res%10);
            node.next = prev;
            prev = node;
            carry = res/10;
        }
        return prev;

        // 22ms
        // get length
//        int size1 = 0, size2 = 0;
//        ListNode node = l1;
//        while (node!=null){
//            size1++;
//            node = node.next;
//        }
//        node = l2;
//        while (node!=null){
//            size2++;
//            node = node.next;
//        }
//
//        // Add 0 to the shorter linked list
//        // Add an extra 0 to both linked lists to handle carry
//        ListNode head = new ListNode(0);
//        node = head;
//        for (int i = 0; i < Math.abs(size1-size2); i++){
//            node.next = new ListNode(0);
//            node = node.next;
//        }
//        if (size1>size2){
//            node.next = l2;
//            l2 = head;
//            head = new ListNode(0);
//            head.next = l1;
//            l1 = head;
//        }
//        else{
//            node.next = l1;
//            l1 = head;
//            head = new ListNode(0);
//            head.next = l2;
//            l2 = head;
//        }
//
//        ListNode res = add(l1, l2);
//        if (res.val==0)
//            return res.next;
//        return res;
//    }
//
//    private ListNode add(ListNode l1, ListNode l2){
//        if (l1==null)
//            return l1;
//        ListNode res = new ListNode(l1.val+l2.val);
//        ListNode succ = add(l1.next, l2.next);
//        if (succ!=null && succ.val>=10){
//            res.val++;
//            succ.val%=10;
//        }
//        res.next = succ;
//        return res;
    }
}
