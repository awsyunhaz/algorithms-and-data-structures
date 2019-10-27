package Leetcode.BinarySearch;

import java.util.HashSet;

public class LongestRepeatingSubstring_1062 {

    // Binary search on length
    public int longestRepeatingSubstring(String S) {
        int lo = 1, hi = S.length();
        while (lo <= hi) {
            int len = (lo + hi) / 2;
            if (search(S, len)) {
                lo = len + 1;
            } else {
                hi = len - 1;
            }
        }
        return lo - 1;
    }

    public boolean search(String S, int len) {
        HashSet<String> seen = new HashSet<>();
        for (int j = 0; j+len <= S.length(); j++) {
            if (seen.contains(S.substring(j, j+len))) {
                return true;
            }
            else
                seen.add(S.substring(j, j+len));
        }
        return false;
    }
}
