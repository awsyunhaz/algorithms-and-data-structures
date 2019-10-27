package Leetcode.TwoPointers;

public class ShortestWordDistance_245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int last = -1, minDis = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word2) || words[i].equals(word1)) {
                if (last >= 0 && (!words[last].equals(words[i]) || word1.equals(word2))) {
                    minDis = Math.min(minDis, Math.abs(i - last));
                }
                last = i;
            }
        }
        return minDis;
    }
}
