package Leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance2_244 {
    private HashMap<String, List<Integer>> map;

    public ShortestWordDistance2_244(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            List<Integer> lis;
            if (!map.containsKey(words[i])){
                lis = new ArrayList<>();
            } else {
                lis = map.get(words[i]);
            }
            lis.add(i);
            map.put(words[i], lis);
        }
    }

    public int shortest(String word1, String word2) {
        int minDis = Integer.MAX_VALUE;
        List<Integer> lis1 = map.get(word1), lis2 = map.get(word2);
        for (int i = 0, j = 0; i < lis1.size() && j < lis2.size();){
            int ind1 = lis1.get(i), ind2 = lis2.get(j);
            minDis = Math.min(minDis, Math.abs(ind1-ind2));
            if (ind1 < ind2) i++;
            if (ind1 > ind2) j++;
        }
        return minDis;
    }
}
