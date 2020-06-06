package Leetcode.Sort;

import java.util.*;

public class GroupAnagrams_49 {
    // Categorize by sorted string
    // O(nklogk), k: string length
//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> map = new HashMap<>();
//        for (String s : strs) {
//            char[] array = s.toCharArray();
//            Arrays.sort(array);
//            String s_sorted = new String(array);
//            if (!map.containsKey(s_sorted))
//                map.put(s_sorted, new ArrayList<>());
//            map.get(s_sorted).add(s);
//        }
//        return new ArrayList<>(map.values());
//    }

    // Categorize by a counter (e.g. 1a2b)
    // O(kn)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] counter = new int[26];
            for (char c: str.toCharArray()) {
                counter[c - 'a'] ++;
            }
            StringBuffer key = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counter[i] > 0) {
                    key.append('a' + i);
                    key.append(counter[i]);
                }
            }
            if (!map.containsKey(key.toString())) {
                map.put(key.toString(), new ArrayList<>());
            }
            map.get(key.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String args[]){
        GroupAnagrams_49 obj = new GroupAnagrams_49();
        System.out.println(obj.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
