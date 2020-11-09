package Leetcode.Graph;

import java.util.HashMap;
import java.util.HashSet;

public class StringTransformIntoAnotherString_1153 {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            // one node has out degree > 1
            if (map.getOrDefault(str1.charAt(i), str2.charAt(i)) != str2.charAt(i)) {
                return false;
            }
            map.put(str1.charAt(i), str2.charAt(i));
        }
        // new one unused char to break cycle if it exists
        return new HashSet<>(map.values()).size() < 26;
    }
}
