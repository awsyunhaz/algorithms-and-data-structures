package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePermutation2_267 {
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuffer sb = new StringBuffer();
        for (char c: map.keySet()) {
            if (map.get(c) % 2 != 0) {
                if (sb.length() > 0) {
                    return res;
                } else {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        expand(res, s, sb, map);
        return res;
    }

    public void expand(List<String> res, String s, StringBuffer sb, HashMap<Character, Integer> map) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c: map.keySet()) {
            if (map.get(c) > 0) {
                sb.insert(0, c);
                sb.append(c);
                map.put(c, map.get(c) - 2);

                expand(res, s, sb, map);
                sb = sb.deleteCharAt(sb.length()-1);
                sb = sb.deleteCharAt(0);
                map.put(c, map.get(c) + 2);
            }
        }
    }
}
