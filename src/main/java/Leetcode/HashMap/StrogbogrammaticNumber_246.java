package Leetcode.HashMap;

import java.util.HashMap;

public class StrogbogrammaticNumber_246 {
    public boolean isStrobogrammatic(String num) {
        int lo = 0, hi = num.length()-1;
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put('0', '0');
        dict.put('1', '1');
        dict.put('6', '9');
        dict.put('9', '6');
        dict.put('8', '8');
        while (lo <= hi) {
            if (!dict.containsKey(num.charAt(lo)) || dict.get(num.charAt(lo)) != num.charAt(hi)) {
                return false;
            }
            lo ++;
            hi --;
        }
        return true;
    }
}
