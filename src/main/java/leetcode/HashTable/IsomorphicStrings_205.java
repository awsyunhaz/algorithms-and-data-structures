package leetcode.HashTable;

import java.util.HashMap;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        // Hashmap - 10ms
//        HashMap<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++){
//            if (map.containsKey(s.charAt(i))) {
//                if (map.get(s.charAt(i)) != t.charAt(i))
//                    return false;
//            }
//            else{
//                if (map.containsValue(t.charAt(i)))
//                    return false;
//                map.put(s.charAt(i), t.charAt(i));
//            }
//        }
//        return true;

        // Char array as map - 4ms
        int[] map1 = new int[256], map2 = new int[256];
        for (int i=0; i<s.length(); i++){
            if (map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;
            map1[s.charAt(i)] = map2[t.charAt(i)] = i+1;
        }
        return true;
    }
}
