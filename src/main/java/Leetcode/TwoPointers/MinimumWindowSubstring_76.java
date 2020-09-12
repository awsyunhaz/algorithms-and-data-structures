package Leetcode.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        int n = t.length();
        for (char c: t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        while (end < s.length()) {
            char chEnd = s.charAt(end++);
            if (counter.containsKey(chEnd)) {
                if (counter.get(chEnd) > 0) {
                    n--;
                }
                counter.put(chEnd, counter.get(chEnd) - 1);
            }
            // contains substring
            while (n == 0) {
                if (end-start < min) {
                    min = Math.min(min, end-start);
                    res = s.substring(start, end);
                }
                char chStart = s.charAt(start++);
                if (counter.containsKey(chStart)) {
                    counter.put(chStart, counter.get(chStart) + 1);
                    // invalidate
                    if (counter.get(chStart) > 0) {
                        n++;
                    }
                }
            }
        }
        return res;
    }
}
