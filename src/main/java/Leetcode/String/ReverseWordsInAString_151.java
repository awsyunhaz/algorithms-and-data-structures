package Leetcode.String;

public class ReverseWordsInAString_151 {
    // split by spaces
//    public String reverseWords(String s) {
//        StringBuffer sb = new StringBuffer();
//        for (String word: s.trim().split("\\s+")) {
//            sb.insert(0, word);
//            sb.insert(0, ' ');
//        }
//        return sb.substring(1).toString();
//    }

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
