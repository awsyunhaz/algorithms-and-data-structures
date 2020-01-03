package Leetcode.String;

public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        int i = words.length-1;
        while (i >= 0 && words[i].length() == 0) { i--; }
        if (i >= 0) {
            sb.append(words[i--]);
        }
        for (; i >= 0; i--) {
            if (words[i].length() > 0) {
                sb.append(" ");
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }
}
