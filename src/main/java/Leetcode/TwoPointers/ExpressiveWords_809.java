package Leetcode.TwoPointers;

public class ExpressiveWords_809 {
//    public int expressiveWords(String S, String[] words) {
//        int res = 0;
//        for (String word: words) {
//            if (isStretchy(S, 0, word, 0)) {
//                res ++;
//            }
//        }
//        return res;
//    }

    // two pointers - recursive
//    public boolean isStretchy(String S, int i, String word, int j) {
//        if (i == S.length() && j == word.length()) {
//            return true;
//        }
//        if (i == S.length() || j == word.length()) {
//            return false;
//        }
//        if (S.charAt(i) == word.charAt(j)) {
//            // no stretch
//            if (isStretchy(S, i+1, word, j+1)) {
//                return true;
//            }
//            // two consecutive char in j
//            if (j+1 < word.length() && word.charAt(j) == word.charAt(j+1)) {
//                i++;
//                j++;
//            } else if (i+2 < S.length() && S.charAt(i+1) == word.charAt(j) && S.charAt(i+2) == word.charAt(j)) {
//                // single char: stretch to at least three
//                i += 2;
//            } else {
//                return false;
//            }
//            while (i < S.length() && S.charAt(i) == word.charAt(j)) {
//                if (isStretchy(S, i+1, word, j+1)) {
//                    return true;
//                }
//                i ++;
//            }
//        }
//        return false;
//    }

    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word: words) {
            if (isStretchy(S, word)) {
                res ++;
            }
        }
        return res;
    }

    // two pointers - iterative
    public boolean isStretchy(String S, String word) {
        int i_left = 0, j_left = 0;
        int S_len = S.length(), word_len = word.length();
        while (i_left < S.length() && j_left < word.length()) {
            if (S.charAt(i_left) == word.charAt(j_left)) {
                int i_right = i_left, j_right = j_left;
                while (i_right < S_len && S.charAt(i_left) == S.charAt(i_right)) {
                    i_right ++;
                }
                while (j_right < word_len && word.charAt(j_left) == word.charAt(j_right)) {
                    j_right ++;
                }
                int group_S = i_right - i_left, group_word = j_right - j_left;
                if (group_S < group_word || (group_word == 1 && group_S == 2)) {
                    return false;
                }
                i_left = i_right;
                j_left = j_right;
            } else {
                return false;
            }
        }
        return (i_left == S.length() && j_left == word.length());
    }
}
