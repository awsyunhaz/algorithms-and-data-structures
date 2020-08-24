package Leetcode.Random;

import java.util.*;

public class GuessTheWord_843 {
    class Master {
        int guess(String str){
            return 0;
        };
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> candidates = new ArrayList<>();
        for (String word: wordlist) {
            candidates.add(word);
        }
        for (int i = 0; i < 10; i++) {
            int ind = (int) (Math.random() * candidates.size());
            String strGuess = candidates.get(ind);
            int numHit = master.guess(strGuess);
            if (numHit == 6) {
                return;
            }
            List<String> newCandidates = new ArrayList<>();
            for (String str: candidates) {
                if (compare(strGuess, str) == numHit && !strGuess.equals(str)) {
                    newCandidates.add(str);
                }
                candidates = newCandidates;
            }
        }
    }

    public int compare(String str1, String str2) {
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                counter ++;
            }
        }
        return counter;
    }
}
