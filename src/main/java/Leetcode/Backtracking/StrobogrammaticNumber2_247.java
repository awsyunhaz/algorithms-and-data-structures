package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StrobogrammaticNumber2_247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> singleCharList = Arrays.asList("0", "1", "8");
        if (n == 1) {
            return singleCharList;
        }
        List<String> res = new ArrayList<>();
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put('0', '0');
        dict.put('1', '1');
        dict.put('6', '9');
        dict.put('9', '6');
        dict.put('8', '8');
        if (n % 2 == 1) {
            for (String str: singleCharList) {
                StringBuffer sb = new StringBuffer(str);
                expand(res, sb, n, dict);
            }
        } else {
            StringBuffer sb = new StringBuffer();
            expand(res, sb, n, dict);
        }
        return res;
    }

    public void expand(List<String> res, StringBuffer sb, int n, HashMap<Character, Character> dict) {
        if (sb.length() == n) {
            if (sb.charAt(0) != '0') {
                res.add(sb.toString());
            }
            return;
        }
        for (char key: dict.keySet()) {
            sb.insert(0, key);
            sb.append(dict.get(key));
            expand(res, sb, n, dict);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
