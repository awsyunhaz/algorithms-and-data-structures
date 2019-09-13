package Leetcode.Design;

import java.util.HashMap;

public class TwoSum3_170 {
    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum3_170() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key: map.keySet()){
            if (value == 2*key && map.get(key)>=2 || value != 2*key && map.containsKey(value-key))
                return true;
        }
        return false;
    }
}
