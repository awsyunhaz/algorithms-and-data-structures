package Leetcode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord_819 {
//    public String mostCommonWord(String paragraph, String[] banned) {
//        HashSet<String> banWords = new HashSet<>(Arrays.asList(banned));
//        HashMap<String, Integer> wordCount = new HashMap<>();
//        int maxCnt = 0;
//        String res = "";
//        paragraph = paragraph.replaceAll("[!?',;.]", " ").toLowerCase();
//        // one or more space
//        for (String word: paragraph.split("\\s+")) {
//            if (!banWords.contains(word)) {
//                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
//                if (wordCount.get(word) > maxCnt) {
//                    maxCnt = wordCount.get(word);
//                    res = word;
//                }
//            }
//        }
//        return res;
//    }

    // build word one by one
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>();
        HashMap<String, Integer> counter = new HashMap<>();
        int maxCnt = 0;
        String res = "";
        for (String word: banned) {
            bannedSet.add(word);
        }

        StringBuffer sb = new StringBuffer();
        // append a extra non-letter character at the end
        paragraph += '.';
        for (char c: paragraph.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (sb.length() > 0){
                String word = sb.toString();
                if (!bannedSet.contains(word)) {
                    counter.put(word, counter.getOrDefault(word, 0) + 1);
                    if (counter.get(word) > maxCnt) {
                        maxCnt = counter.get(word);
                        res = word;
                    }
                }
                sb = new StringBuffer();
            }
        }
        return res;
    }
}
