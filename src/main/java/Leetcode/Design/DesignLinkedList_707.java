package Leetcode.Design;

public class DesignLinkedList_707 {
    public class ListNode {
        int val;
        ListNode prev, next;
        public ListNode (int v) {
            val = v;
        }
    }

    private int length;
    private ListNode head;

    /** Initialize your data structure here. */
    public DesignLinkedList_707() {
        head = new ListNode(0);
        length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < length) {
            ListNode node = head;
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
            return node.val;
        } else {
            return -1;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        if (index <= length) {
            ListNode node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
            length ++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < length) {
            ListNode node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            length --;
        }
    }
}
