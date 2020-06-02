package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class NumberOfAtoms_726 {
    public String countOfAtoms(String formula) {
        HashMap<String, Integer> res = work(formula, 0, formula.length()-1);
        List<String> atoms = new ArrayList<>(res.keySet());
        Collections.sort(atoms);
        StringBuffer sb = new StringBuffer();
        for (String atom: atoms) {
            String cnt = res.get(atom).toString();
            if (cnt.equals("1")) cnt = "";
            sb.append(atom + cnt);
        }
        return sb.toString();
    }

    public HashMap<String, Integer> work(String formula, int lo, int hi) {
        HashMap<String, Integer> map = new HashMap();
        while (lo <= hi) {
            char c = formula.charAt(lo);
            if (c == '(') {
                int para_cnt = 1;
                int h = lo + 1;
                for (; h <= hi; h++){
                    if (formula.charAt(h) == '(')
                        para_cnt ++;
                    else if (formula.charAt(h) == ')')
                        para_cnt --;
                    if (para_cnt == 0){
                        HashMap<String, Integer> subMap = work(formula, lo + 1, h - 1);
                        int num = 0;
                        while (++h <= hi && formula.charAt(h) >= '0' && formula.charAt(h) <= '9'){
                            num = num * 10 + (formula.charAt(h) - '0');
                        }
                        num = num == 0? 1: num;
                        for (String key: subMap.keySet()) {
                            map.put(key, map.getOrDefault(key, 0) + subMap.get(key)*num);
                        }
                        lo = h;
                        break;
                    }
                }
            } else if (c >= 'A' && c <= 'Z') {
                String element = Character.toString(c);
                int num = 0;
                while (++lo <= hi) {
                    c = formula.charAt(lo);
                    if (c >= 'a' && c <= 'z') {
                        element += c;
                    } else if (c >= '0' && c <= '9') {
                        num = num * 10 + (formula.charAt(lo) - '0');
                    } else {
                        break;
                    }
                }
                if (num == 0) num = 1;
                map.put(element, map.getOrDefault(element, 0) + num);
            }
        }
        return map;
    }
}
