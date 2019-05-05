package Berkeley.CS61B.assignment.proj1a;

public class LinkedListDeque<Item> {
    private class Node{
        private Item item;
        private Node prev;
        private Node next;

        public Node(Item i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item to the front of the Deque.*/
    public void addFirst(Item i){
        Node n = new Node(i, sentinel, sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;
        size ++;
    }

    /** Adds an item to the back of the Deque.*/
    public void addLast(Item i){
        Node n = new Node(i, sentinel.prev, sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
        size ++;
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        return (sentinel.next == sentinel);
    }

    /** Returns the number of items in the Deque.*/
    public int size(){
        return size;
    }

    /** Prints the items in the Deque from first to last,
     * separated by a space.*/
    public void printDeque(){
        for (Node n = sentinel.next; n != sentinel; n = n.next){
            System.out.print(n.item + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the
     * Deque. If no such item exists, returns null.*/
    public Item removeFirst(){
        if (size == 0)
            return null;
        Item n = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size --;
        return n;
    }

    /** Removes and returns the item at the back of the Deque.
     * If no such item exists, returns null.*/
    public Item removeLast(){
        if (size == 0)
            return null;
        Item n = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size --;
        return n;
    }

    /** Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!*/
    public Item get(int index){
        if (index > size)
            return null;
        Node n = sentinel.next;
        while (index > 0){
            n = n.next;
            index --;
        }
        return n.item;
    }

    private Item helper(Node n, int index){
        if (index == 0)
            return n.item;
        return helper(n.next, index - 1);
    }

    public Item getRecursive(int index){
        if (index > size)
            return null;
        return helper(sentinel.next, index);
    }
}
