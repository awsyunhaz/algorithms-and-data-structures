package Leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString2_186 {
//    public void reverseWords(char[] s) {
//        List<String> list = new ArrayList<>();
//        StringBuffer sb = new StringBuffer();
//        for (char c: s) {
//            if (c == ' ') {
//                list.add(0, sb.toString());
//                sb = new StringBuffer();
//            } else {
//                sb.append(c);
//            }
//        }
//        list.add(0, sb.toString());
//        sb = new StringBuffer();
//        for (String str: list) {
//            sb.append(' ');
//            sb.append(str);
//        }
//        String str = sb.substring(1).toString();
//        for (int i = 0; i < s.length; i++) {
//            s[i] = str.charAt(i);
//        }
//    }

    // reverse in place
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int left = 0;
        for (int right = 0; right < s.length; right++) {
            if (s[right] == ' ') {
                reverse(s, left, right - 1);
                left = right + 1;
            }
        }
        reverse(s, left, s.length-1);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start ++;
            end --;
        }
    }
}
