package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", s, 0, 0);
        return res;
    }

    public void backtrack(List<String> res, String curr, String s, int start, int section) {
        if (start == s.length() || section == 4) {
            if (start == s.length() && section == 4) {
                res.add(curr);
            }
            return;
        }
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String tmpStr = curr;
            String newSec = s.substring(start, start+i);
            if (newSec.charAt(0) == '0' && newSec.length() > 1)
                continue;
            if (Integer.valueOf(newSec) >= 0 && Integer.valueOf(newSec) <= 255) {
                tmpStr += s.substring(start, start+i);
                if (section < 3) {
                    tmpStr += ".";
                }
                backtrack(res, tmpStr, s, start+i, section+1);
            }
        }
    }
}
