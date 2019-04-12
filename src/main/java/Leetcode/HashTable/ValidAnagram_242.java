package Leetcode.HashTable;

import java.util.Arrays;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        // Array - 3ms
        int[] cnt = new int[256];
        Arrays.fill(cnt, 0);
        for (char c: s.toCharArray())
            cnt[c]++;
        for (char c: t.toCharArray())
            cnt[c]--;
        for (int i = 0; i < 256; i++){
            if (cnt[i]!=0)
                return false;
        }
        return true;

        //Hashset - 18ms
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (char c: s.toCharArray())
//            map.put(c, map.getOrDefault(c, 0)+1);
//        for (char c: t.toCharArray()){
//            if (!map.containsKey(c))
//                return false;
//            int count = map.get(c);
//            if (count==1)
//                map.remove(c);
//            else
//                map.put(c, count-1);
//        }
//        if (map.size()!=0)
//            return false;
//        return true;
    }
}
