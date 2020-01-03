package Leetcode.Greedy;

public class GasStation_134 {
    // If cannot get to next station, set next station as new start
    // (If A cannot get to B, any station between A and B cannot get to B)
    // If total < 0, no solution
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curr = 0, res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                res = i + 1;
                curr = 0;
            }
        }
        if (total < 0) {
            return -1;
        } else {
            return res;
        }
    }
}
