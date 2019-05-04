package Berkeley.CS61B.lecture.AListsResizingvsSLists6;

/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item> {
    /** Creates an empty list. */
    private Item[] items;
    private int size;

    public AList() {
        items = (Item[]) new Object[100];
    }

    /** Resize the array to target capacity*/
    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(a, 0, items,0, items.length);
        items = a;
    }

    /** Inserts X into the back of the list.
     *  Add item to position size*/
    public void addLast(Item x) {
        if (items.length == size) {
            // This is how Python list is implemented
            resize(size * 10);
        }
        items[size] = x;
        size ++;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size --;
        if (items.length < size / 4)
            resize(size / 4);
        return x;
    }
} 