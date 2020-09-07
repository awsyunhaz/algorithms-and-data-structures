package Leetcode.DynamicProgramming;

public class EditDistance_72 {
//    // recursion with memorization
//    public int minDistance(String word1, String word2) {
//        int len1 = word1.length(), len2 = word2.length();
//        int[][] memory = new int[len1+1][len2+1];
//        for (int i = 0; i <= len1; i++) {
//            memory[i][0] = i;
//        }
//        for (int j = 0; j <= len2; j++) {
//            memory[0][j] = j;
//        }
//        return minDistance(word1, len1, word2, len2, memory);
//    }
//
//    public int minDistance(String word1, int i, String word2, int j, int[][] memory) {
//        if ((i == 0 && j == 0) || memory[i][j] > 0) {
//            return memory[i][j];
//        }
//        if (word1.charAt(i-1) == word2.charAt(j-1)) {
//            return minDistance(word1, i-1, word2, j-1, memory);
//        } else {
//            int replace = minDistance(word1, i-1, word2, j-1, memory);
//            int insert = minDistance(word1, i-1, word2, j, memory);
//            int delete = minDistance(word1, i, word2, j-1, memory);
//            int distance = Math.min(Math.min(replace, insert), delete) + 1;
//            memory[i][j] = distance;
//            return distance;
//        }
//    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] f = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            f[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    f[i][j] = f[i-1][j-1];
                } else {
                    // minimum among insert, delete, replace
                    f[i][j] = Math.min(Math.min(f[i-1][j], f[i][j-1]), f[i-1][j-1]) + 1;
                }
            }
        }
        return f[m][n];
    }
}
