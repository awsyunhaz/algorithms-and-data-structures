package Leetcode.Backtracking;

import java.util.TreeSet;

public class BraceExpansion_1087 {
    public String[] expand(String S) {
        TreeSet<String> res = new TreeSet<>();
        StringBuffer sb = new StringBuffer();
        search(res, S, sb, 0);
        return res.toArray(new String[res.size()]);
    }

    public void search(TreeSet<String> res, String str, StringBuffer sb, int i) {
        if (i == str.length()) {
            res.add(sb.toString());
            return;
        }
        if (str.charAt(i) == '{') {
            int j = i + 1;
            while (str.charAt(j) != '}')  {
                j++;
            }
            for (String c: str.substring(i+1, j).split(",")) {
                sb.append(c);
                search(res, str, sb, j+1);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(str.charAt(i));
            search(res, str, sb, i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
