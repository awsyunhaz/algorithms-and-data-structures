package Berkeley.CS61B.lecture.InheritanceImplements8;

public interface List61B<Item> {

    /** Inserts X into the back of the list.
     *  Add item to position size*/
    public void addLast(Item x);

    /** Returns the item from the back of the list. */
    public Item getLast();

    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i);

    /** Returns the number of items in the list. */
    public int size();

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Item removeLast();

    public void insert(Item x, int position);

    public void addFirst(Item x);

    public Item getFirst();

    default public void print(){
        for (int i = 0; i < size(); i++){
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

}
