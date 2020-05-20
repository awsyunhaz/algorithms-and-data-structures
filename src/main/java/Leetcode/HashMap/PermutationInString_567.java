package Leetcode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationInString_567 {
    // permutate - O(n!)
//    public boolean checkInclusion(String s1, String s2) {
//        List<String> perms = new ArrayList<>();
//        perms.add(s1.substring(0, 1));
//        for (int i = 1; i < s1.length(); i++) {
//            List<String> new_perms = new ArrayList<>();
//            for (String str: perms) {
//                for (int pos = 0; pos <= i; pos++) {
//                    String new_str = str.substring(0, pos) + s1.charAt(i) + str.substring(pos);
//                    new_perms.add(new_str);
//                }
//            }
//            perms = new_perms;
//        }
//        for (String str: perms) {
//            if (s2.indexOf(str) != -1) {
//                return true;
//            }
//        }
//        return false;
//    }

    // hash map - O(n), 15ms
//    public boolean checkInclusion(String s1, String s2) {
//        if (s2.length() < s1.length()) {
//            return false;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c: s1.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for (int i = 0; i < s1.length(); i++) {
//            char c = s2.charAt(i);
//            map.put(c, map.getOrDefault(c, 0) - 1);
//            if (map.get(c) == 0) {
//                map.remove(c);
//            }
//        }
//        if (map.isEmpty()) {
//            return true;
//        }
//        int lo = 0, hi = s1.length();
//        while (hi < s2.length()) {
//            char c_lo = s2.charAt(lo++), c_hi = s2.charAt(hi++);
//            map.put(c_lo, map.getOrDefault(c_lo, 0) + 1);
//            if (map.get(c_lo) == 0) {
//                map.remove(c_lo);
//            }
//            map.put(c_hi, map.getOrDefault(c_hi, 0) - 1);
//            if (map.get(c_hi) == 0) {
//                map.remove(c_hi);
//            }
//            if (map.isEmpty()) {
//                return true;
//            }
//        }
//        return false;
//    }

    // O(n), use array counter, faster 8ms
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int non_zero = 0;
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        if (allZeros(arr)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            arr[s2.charAt(i-s1.length()) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
            if (allZeros(arr)) {
                return true;
            }
        }
        return false;
    }

    public boolean allZeros(int[] arr) {
        for (int cnt: arr) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
