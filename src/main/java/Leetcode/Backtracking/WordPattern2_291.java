package Leetcode.Backtracking;

import java.util.HashMap;

public class WordPattern2_291 {
    // O(n^m)
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        return wordPatternMatch(pattern, str, 0, 0, map);
    }

    public boolean wordPatternMatch(String pattern, String str, int i, int j, HashMap<Character, String> map) {
        if (i == pattern.length() && j == str.length()) {
            return true;
        }
        if (i == pattern.length() || j == str.length() || str.length()-j < pattern.length()-i) {
            return false;
        }
        char key = pattern.charAt(i);
        // seen the key before
        if (map.containsKey(key)) {
            String word = map.get(key);
            int len = word.length();
            if (j + len <= str.length() && word.equals(str.substring(j, j+len))) {
                return wordPatternMatch(pattern, str, i+1, j+len, map);
            } else {
                return false;
            }
            // not seen this key, try every possible substring
        } else {
            for (int end = j+1; end <= str.length(); end++) {
                String word = str.substring(j, end);
                if (!map.containsValue(word)) {
                    map.put(key, word);
                    if (wordPatternMatch(pattern, str, i+1, end, map)) {
                        return true;
                    }
                    map.remove(key);
                }
            }
            return false;
        }
    }
}
