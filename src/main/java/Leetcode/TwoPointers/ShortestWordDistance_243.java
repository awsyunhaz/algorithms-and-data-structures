package Leetcode.TwoPointers;

public class ShortestWordDistance_243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int ind1 = -1, ind2 = -1, min = words.length;
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1))
                ind1 = i;
            if (words[i].equals(word2))
                ind2 = i;
            if (ind1 >= 0 && ind2 >= 0 && Math.abs(ind1-ind2) < min)
                min = Math.abs(ind1-ind2);
        }
        return min;
    }
}
