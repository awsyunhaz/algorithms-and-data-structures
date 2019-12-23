package Leetcode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OptimalAccountBalancing_465 {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] tran: transactions) {
            map.put(tran[0], map.getOrDefault(tran[0], 0) + tran[2]);
            map.put(tran[1], map.getOrDefault(tran[1], 0) - tran[2]);
        }
        return dfs(new ArrayList<>(map.values()), 0);
    }

    public int dfs(List<Integer> balance, int start) {
        while (start < balance.size() && balance.get(start) == 0) {
            start ++;
        }
        if (start == balance.size()) {
            return 0;
        }
        int times = Integer.MAX_VALUE;
        for (int i = start + 1; i < balance.size(); i++) {
            if (balance.get(start) * balance.get(i) < 0) {
                balance.set(i, balance.get(i) + balance.get(start));
                times = Math.min(times, 1 + dfs(balance, start+1));
                balance.set(i, balance.get(i) - balance.get(start));
            }
        }
        return times;
    }
}
