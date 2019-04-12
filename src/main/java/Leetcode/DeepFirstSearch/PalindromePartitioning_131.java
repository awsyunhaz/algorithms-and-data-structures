package Leetcode.DeepFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String remain = new String(s);
        search (s, list, remain, result);
        for (List<String> temp: result)
            System.out.println(temp);
        return result;
    }

    private void search(String s, List<String> list, String remain,
                        List<List<String>> result){
        if (remain.length()==0){
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < remain.length(); i++){
            if (isPalindrome(remain.substring(0, i+1))) {
                list.add(remain.substring(0, i + 1));
                remain = remain.substring(i + 1);
                search(s, list, remain, result);
                remain = list.get(list.size() - 1).concat(remain);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int lo = 0, hi = s.length()-1;
        while (lo < hi){
            if (s.charAt(lo) != s.charAt(hi))
                return false;
            lo++; hi--;
        }
        return true;
    }

    public static void main(String[] args){
        PalindromePartitioning_131 obj = new PalindromePartitioning_131();
        obj.partition("aabab");
    }

}
