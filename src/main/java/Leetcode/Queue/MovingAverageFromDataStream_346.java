package Leetcode.Queue;

import java.util.ArrayList;
import java.util.List;

public class MovingAverageFromDataStream_346 {
    private List<Integer> list;
    private int size;
    private double sum;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream_346(int size) {
        list = new ArrayList<>();
        sum = 0.0;
        this.size = size;
    }

    public double next(int val) {
        if (list.size() == size) {
            sum -= list.get(0);
            list.remove(0);
        }
        sum += val;
        list.add(val);
        return sum / list.size();
    }
}
