package Leetcode.HashMap;

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

    // index map
//    public boolean wordPattern(String pattern, String s) {
//        HashMap<Character, Integer> patternMap = new HashMap();
//        HashMap<String, Integer> wordMap = new HashMap();
//        String[] strList = s.split(" ");
//        if (pattern.length() != strList.length) {
//            return false;
//        }
//        for (int i = 0; i < pattern.length(); i++) {
//            if (patternMap.containsKey(pattern.charAt(i)) && wordMap.containsKey(strList[i])) {
//                if (!patternMap.get(pattern.charAt(i)).equals(wordMap.get(strList[i])))
//                    return false;
//            } else if (patternMap.containsKey(pattern.charAt(i)) || wordMap.containsKey(strList[i])) {
//                return false;
//            }
//            patternMap.put(pattern.charAt(i), i);
//            wordMap.put(strList[i], i);
//        }
//        return true;
//    }
}
