package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofPhoneNumber_17 {

    // 0ms
//    public List<String> letterCombinations(String digits) {
//        List<String> res = new ArrayList<>();
//        if (digits.length()==0) return res;
//        res.add("");
//        return helper(res, digits);
//    }
//
//    private List<String> helper(List<String> list, String digits){
//        if (digits.length()==0)
//            return list;
//        String newDigit = new String();
//        switch (digits.charAt(0)){
//            case '2': newDigit = "abc"; break;
//            case '3': newDigit = "def"; break;
//            case '4': newDigit = "ghi"; break;
//            case '5': newDigit = "jkl"; break;
//            case '6': newDigit = "mno"; break;
//            case '7': newDigit = "pqrs"; break;
//            case '8': newDigit = "tuv"; break;
//            case '9': newDigit = "wxyz"; break;
//        }
//        List<String> res = new ArrayList<String>();
//        for (String s: list){
//            for (char d: newDigit.toCharArray()){
//                res.add(s+d);
//            }
//        }
//        return helper(res, digits.substring(1, digits.length()));
//    }

    // Backtrack - 0ms
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length()==0) return res;
        helper(res, "", digits);
        return res;
    }

    private void helper(List<String> res, String str, String digits){
        if (digits.length()==0){
            res.add(str);
            return;
        }
        String newDigit = new String();
        switch (digits.charAt(0)){
            case '2': newDigit = "abc"; break;
            case '3': newDigit = "def"; break;
            case '4': newDigit = "ghi"; break;
            case '5': newDigit = "jkl"; break;
            case '6': newDigit = "mno"; break;
            case '7': newDigit = "pqrs"; break;
            case '8': newDigit = "tuv"; break;
            case '9': newDigit = "wxyz"; break;
        }
        for (char d: newDigit.toCharArray())
            helper(res, str+d, digits.substring(1));
    }
}
