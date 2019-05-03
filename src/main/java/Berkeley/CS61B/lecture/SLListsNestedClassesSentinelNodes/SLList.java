//package Berkeley.CS61B.lecture.SLListsNestedClassesSentinelNodes;

public class SLList {
    private IntNode sentinel;
    private int size;

    //Nested class: class subordinate to other classes
    //We can declare static, since it never uses SLList's instance
    //variables or methods
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    public SLList(){
        //dummy head
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLList(int x){
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x){
        IntNode first = new IntNode(x, sentinel.next);
        sentinel.next = first;
        size ++;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public void addLast(int x){
        IntNode n = sentinel;
        while (n.next != null)
            n = n.next;
        n.next = new IntNode(x, null);
        size ++;
    }

    //static helper class
//    private static int size(IntNode n){
//        if (n == null)
//            return 0;
//        return size(n.next) + 1;
//    }

    public int size(){
//        return size(first);
        return size;
    }

    public static void main(String[] args){
        SLList s = new SLList(15);
        s.addFirst(10);
        s.addFirst(5);
        System.out.println(s.size());

        s = new SLList();
        s.addFirst(10);
        s.addLast(15);
        System.out.println(s.size());
    }
}
