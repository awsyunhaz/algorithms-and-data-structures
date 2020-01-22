package Leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion_6 {
//    public String convert(String s, int numRows) {
//        if (numRows == 1) {
//            return s;
//        }
//        StringBuffer sb = new StringBuffer();
//        // length of a V
//        int len = (numRows-1)*2;
//        for (int i = 0; i < numRows; i++) {
//            int interval = 2*i;
//            if (i == 0 || i == numRows-1) {
//                interval = len;
//            }
//            for (int j = i; j < s.length(); j += interval) {
//                sb.append(s.charAt(j));
//                if (i > 0 && i < numRows-1) {
//                    interval = len - interval;
//                }
//            }
//        }
//        return sb.toString();
//    }

    // List of StringBuffer - 15ms
    public String convert (String s,int numRows){
        if (numRows == 1) return s;
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) list.add(new StringBuffer());
        int listIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(listIndex).append(s.charAt(i));
            if (i / (numRows - 1) % 2 == 0) listIndex++;
            else listIndex--;
        }
        String res = "";
        for (StringBuffer sb : list) {
            res += sb.toString();
        }
        return res;
    }
}
