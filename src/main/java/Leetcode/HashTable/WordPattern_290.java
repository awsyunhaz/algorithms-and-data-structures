package Leetcode.HashTable;

import java.util.HashMap;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        // Hashmap - 1ms
        // Similar to problem 205
        HashMap<Character, String> map = new HashMap<>();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;
        for (int i=0; i<pattern.length(); i++){
            if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(strs[i]))
                    return false;
            }
            else{
                if (map.containsValue(strs[i]))
                    return false;
                map.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }
}
