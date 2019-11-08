package Leetcode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> lis = new ArrayList<>();
        search(s, res, lis, 0, 0);
        return res;
    }

    public void search(String s, List<List<String>> res, List<String> lis, int start, int end){
        if (start == s.length()) {
            res.add(new ArrayList<>(lis));
            return;
        }
        for (int i = start; i < s.length(); i++){
            if (isPalindrome(s, start, i)){
                lis.add(s.substring(start, i+1));
                search(s, res, lis, i+1, i+1);
                lis.remove(lis.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
