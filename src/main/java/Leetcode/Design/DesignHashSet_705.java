package Leetcode.Design;

import java.util.LinkedList;
import java.util.List;

public class DesignHashSet_705 {
    List<LinkedList<Integer>> lis;

    /** Initialize your data structure here. */
    public DesignHashSet_705() {
        lis = new LinkedList<>();
    }

    public void add(int key) {
        int ind = key % 1000;
        while (lis.size() <= ind) {
            lis.add(new LinkedList<>());
        }
        LinkedList<Integer> bucket = lis.get(ind);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int ind = key % 1000;
        if (ind >= lis.size()) {
            return;
        }
        LinkedList<Integer> bucket = lis.get(ind);
        bucket.remove(new Integer(key));
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int ind = key % 1000;
        if (ind >= lis.size()) {
            return false;
        }
        LinkedList<Integer> bucket = lis.get(ind);
        return bucket.contains(key);
    }
}
