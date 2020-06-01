package Leetcode.Array;

import java.util.HashSet;

public class CircularArrayLoop_457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            int ind = i, dir = nums[i];
            boolean flag = true;
            HashSet<Integer> seen = new HashSet<>();
            // keeping going until finds a loop or a different direction
            while (!seen.contains(ind) && nums[ind] * dir > 0) {
                visited[ind] = true;
                seen.add(ind);
                // -1000 ≤ nums[i] ≤ 1000
                int nextInd = (ind + nums[ind] % nums.length + nums.length) % nums.length;
                // self loop
                if (ind == nextInd) {
                    flag = false;
                    break;
                }
                ind = nextInd;
            }
            if (flag && seen.contains(ind)) {
                return true;
            }
        }
        return false;
    }
}
