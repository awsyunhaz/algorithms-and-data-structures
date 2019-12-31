package Leetcode.Design;

import java.util.HashMap;
import java.util.Map;

public class InsertDeleteGetRandomO1_380 {

    private Map<Integer, Integer> valToInd;
    private Map<Integer, Integer> indToVal;

    /** Initialize your data structure here. */
//    public RandomizedSet() {
    public InsertDeleteGetRandomO1_380() {
        valToInd = new HashMap<>();
        indToVal = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToInd.containsKey(val)) {
            return false;
        }
        valToInd.put(val, valToInd.size());
        indToVal.put(indToVal.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToInd.containsKey(val)) {
            return false;
        }
        // move the last element to the index of the element to delete
        int index = valToInd.get(val);
        int lastVal = indToVal.get(indToVal.size()-1);
        indToVal.put(index, lastVal);
        indToVal.remove(indToVal.size()-1);
        valToInd.put(lastVal, index);
        valToInd.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int ind = (int) (Math.random() * valToInd.size());
        return indToVal.get(ind);
    }
}
