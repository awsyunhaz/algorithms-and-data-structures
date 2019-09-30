package Leetcode.HashMap;

import java.util.HashSet;

public class JewelsandStones_771 {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> seen = new HashSet<>();
        for (char c: J.toCharArray())
            seen.add(c);
        int cnt = 0;
        for (char c: S.toCharArray()){
            if (seen.contains(c))
                cnt++;
        }
        return cnt;
    }
}
