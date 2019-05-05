package Berkeley.CS61B.assignment.proj1a;

public class ArrayDeque<Item> {
    private Item[] arr;
    private int nextFirst, nextLast;
    private static int REFRACTOR = 4;

    public ArrayDeque(){
        arr = (Item[]) new Object[8];
        nextFirst = arr.length / 2;
        nextLast = arr.length / 2 + 1;
    }

    private void resize(int capacity){
        Item[] newArr = (Item[]) new Object[capacity];
        int numFirst = arr.length - nextFirst - 1;
        System.arraycopy(arr, nextFirst, newArr, capacity - numFirst, numFirst);
        System.arraycopy(arr, 0, newArr, 0, nextLast);
        arr = newArr;
    }

    private int minusOne(int i){
        if (i - 1 < 0)
            return arr.length - 1;
        return i - 1;
    }

    /** Adds an item to the front of the Deque.*/
    public void addFirst(Item i){
//        if (nextFirst == nextLast - 1)
//            resize(arr.length * REFRACTOR);
        arr[nextFirst] = i;
        nextFirst = minusOne(nextFirst);
    }

    private int plusOne(int i){
        if (i + 1 == arr.length)
            return 0;
        return i + 1;
    }

    /** Adds an item to the back of the Deque.*/
    public void addLast(Item i){
//        if (nextFirst == nextLast - 1)
//            resize(arr.length * REFRACTOR);
        arr[nextLast] = i;
        nextLast = plusOne(nextLast);
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        return (plusOne(nextFirst) == nextLast);
    }

    /** Returns the number of items in the Deque.*/
    public int size(){
        if (nextFirst < nextLast)
            return nextLast - nextFirst - 1;
        else
            return nextLast - nextFirst + arr.length - 1;
    }

    /** Prints the items in the Deque from first to last, separated by a space.*/
    public void printDeque(){
        for (int i = plusOne(nextFirst); i < nextLast; i = plusOne(i)){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the Deque. If no such item exists, returns null.*/
    public Item removeFirst(){
        if (plusOne(nextFirst) == nextLast)
            return null;
        Item i = arr[plusOne(nextFirst)];
        arr[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        return i;
    }

    /** Removes and returns the item at the back of the Deque. If no such item exists, returns null.*/
    public Item removeLast(){
        if (minusOne(nextLast) == nextFirst)
            return null;
        Item i = arr[minusOne(nextLast)];
        arr[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        return i;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!*/
    public Item get(int index){
        if (index > size())
            return null;
        int ind = (plusOne(nextFirst) + index) % arr.length;
        if (ind > nextLast)
            return null;
        return arr[ind];
    }
}
