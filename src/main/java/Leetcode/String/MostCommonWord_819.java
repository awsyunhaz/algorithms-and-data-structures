package Leetcode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> banWords = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> wordCount = new HashMap<>();
        int maxCnt = 0;
        String res = "";
        paragraph = paragraph.replaceAll("[!?',;.]", " ").toLowerCase();
        for (String word: paragraph.split("\\s+")) {
            if (!banWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                if (wordCount.get(word) > maxCnt) {
                    maxCnt = wordCount.get(word);
                    res = word;
                }
            }
        }
        return res;
    }
}
