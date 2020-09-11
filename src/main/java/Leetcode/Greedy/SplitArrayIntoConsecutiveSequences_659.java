package Leetcode.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SplitArrayIntoConsecutiveSequences_659 {
    // O(N)
    // Greedily extend sequence with counter
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        for (int num: nums) {
            int count = counter.get(num);
            if (count > 0) {
                counter.put(num, count - 1);
                if (end.getOrDefault(num-1, 0) > 0) {
                    // entend the previous seq
                    end.put(num-1, end.get(num-1) - 1);
                    end.put(num, end.getOrDefault(num, 0) + 1);
                } else {
                    // create a new seq
                    if (counter.getOrDefault(num+1, 0) == 0 || counter.getOrDefault(num+2, 0) == 0) {
                        return false;
                    } else {
                        counter.put(num + 1, counter.get(num+1) - 1);
                        counter.put(num + 2, counter.get(num+2) - 1);
                        end.put(num + 2, end.getOrDefault(num+2, 0) + 1);
                    }
                }
            }
        }
        return true;
    }
}
