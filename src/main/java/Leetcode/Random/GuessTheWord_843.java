package Leetcode.Random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GuessTheWord_843 {
    class Master {
        int guess(String str){
            return 0;
        };
    }

    public void findSecretWord(String[] wordlist, Master master) {
        Set<String> candidates = new HashSet(Arrays.asList(wordlist));
        for (int i = 0; i < 10; i++) {
            int ind = (int) (Math.random()*candidates.size());
            String guessStr = candidates.toArray(new String[candidates.size()])[ind];
            int res = master.guess(guessStr);
            Set<String> newSet = new HashSet();
            for (String cand: candidates) {
                if (match(cand, guessStr) == res) {
                    newSet.add(cand);
                }
            }
            candidates = newSet;
        }
    }

    public int match(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
