package Leetcode.DynamicProgramming;

import java.util.HashMap;

public class OnesAndZeros_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int f[][] = new int[m+1][n+1];
        HashMap<String, Integer> map = new HashMap<>();
        for (String str: strs) {
            int m_cnt = 0;
            for (char c: str.toCharArray()) {
                if (c == '0') {
                    m_cnt ++;
                }
            }
            map.put(str, m_cnt);
        }
        for (String str: strs) {
            int m_cnt = map.get(str);
            int n_cnt = str.length() - map.get(str);
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i >= m_cnt && j >= n_cnt){
                        f[i][j] = Math.max(f[i][j], f[i-m_cnt][j-n_cnt] + 1);
                    }
                }
            }
        }
        return f[m][n];
    }
}
