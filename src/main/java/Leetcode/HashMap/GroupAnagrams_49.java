package Leetcode.HashMap;

import java.util.*;

// Categorize by algorithms.sort (or by count)
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String s_sorted = new String(array);
            if (!map.containsKey(s_sorted))
                map.put(s_sorted, new ArrayList<>());
            map.get(s_sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String args[]){
        GroupAnagrams_49 obj = new GroupAnagrams_49();
        System.out.println(obj.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
