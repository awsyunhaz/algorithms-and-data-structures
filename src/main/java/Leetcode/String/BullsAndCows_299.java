package Leetcode.String;

public class BullsAndCows_299 {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int[] sCnt = new int[10];
        int[] gCnt = new int[10];
        int A = 0, B = 0;
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A ++;
            } else {
                sCnt[secret.charAt(i) - '0'] ++;
                gCnt[guess.charAt(i) - '0'] ++;
            }

        }
        for (int i = 0; i < 10; i++) {
            B += Math.min(sCnt[i], gCnt[i]);
        }
        return Integer.toString(A) + 'A' + Integer.toString(B) + 'B';
    }
}
