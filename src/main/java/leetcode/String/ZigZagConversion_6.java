package leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion_6 {
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
