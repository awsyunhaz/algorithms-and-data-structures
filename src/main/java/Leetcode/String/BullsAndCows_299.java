package Leetcode.String;

public class BullsAndCows_299 {
//    public String getHint(String secret, String guess) {
//        int[] counter = new int[10];
//        for (char c: secret.toCharArray()) {
//            counter[c - '0'] ++;
//        }
//        int bulls = 0, cows = 0;
//        for (int i = 0; i < secret.length(); i++) {
//            if (guess.charAt(i) == secret.charAt(i)) {
//                bulls ++;
//                counter[guess.charAt(i) - '0'] --;
//            }
//        }
//        for (int i = 0; i < secret.length(); i++) {
//            if (guess.charAt(i) != secret.charAt(i) && counter[guess.charAt(i) - '0'] > 0) {
//                cows ++;
//                counter[guess.charAt(i) - '0'] --;
//            }
//        }
//        return new String(bulls + "A" + cows + "B");
//    }

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
