package Leetcode.HashMap;

import java.util.HashSet;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        HashSet<Integer> numSet = new HashSet<>();
        while (n != 1 && !numSet.contains(n)) {
            numSet.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
