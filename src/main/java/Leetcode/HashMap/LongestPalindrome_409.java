package Leetcode.HashMap;

import java.util.HashMap;

public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        int res = 0;
        boolean flag = false;
        for (char c: s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for (int count: counter.values()) {
            res += count;
            if (count % 2 != 0) {
                if (!flag) {
                    flag = true;
                } else {
                    res --;
                }
            }
        }
        return res;
    }
}
