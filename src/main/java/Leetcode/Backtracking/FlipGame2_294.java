package Leetcode.Backtracking;

import java.util.HashMap;

public class FlipGame2_294 {
    // backtrack with memorization, O(n!!)
    public boolean canWin(String s) {
        HashMap<String, Boolean> mem = new HashMap<>();
        return canWin(s, mem);
    }

    public boolean canWin(String s, HashMap<String, Boolean> mem) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                String strFlip = s.substring(0, i) + "--" + s.substring(i+2);
                if (!canWin(strFlip)) {
                    mem.put(s, true);
                    return true;
                }
            }
        }
        mem.put(s, false);
        return false;
    }
}
