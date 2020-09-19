package Leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class FlipGame_293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - 2; i++) {
            String toFlip = s.substring(i, i+2);
            if (toFlip.equals("++")) {
                String pre = s.substring(0, i);
                String post = s.substring(i+2);
                ans.add(pre + "--" + post);
            }
        }
        return ans;
    }
}
