package Leetcode.HashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {

        // O(n) - 48ms
//        HashMap<String, Integer> map = new HashMap<>();
//        List<String> res = new ArrayList<>();
//        StringBuffer temp = new StringBuffer();
//        if (s.length()<10)
//            return res;
//        temp.append(s.substring(0, 10));
//        map.put(temp.toString(), 1);
//        for (int i = 10; i < s.length(); i++){
//            temp.deleteCharAt(0).append(s.charAt(i));
//            String str = temp.toString();
//            int count = map.getOrDefault(str, 0);
//            if (count==1)
//                res.add(str);
//            map.put(str, count+1);
//        }
//        return res;

        // O(n) - 16ms
        // Two sets
        HashSet<String> res = new HashSet<>(), seen = new HashSet<>();
        for (int i = 0; i <= s.length()-10; i++){
            if (!seen.add(s.substring(i, i+10)))
                res.add(s.substring(i, i+10));
        }
        return new ArrayList<>(res);
    }
}
