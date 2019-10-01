package Leetcode.String;

import java.util.HashMap;

public class SingleRowKeyboard_1165 {

    // HashMap
//    public int calculateTime(String keyboard, String word) {
//        int res = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < keyboard.length(); i++){
//            map.put(keyboard.charAt(i), i);
//        }
//        res += Math.abs(map.get(word.charAt(0)) - map.get(keyboard.charAt(0)));
//        for (int i = 1; i < word.length(); i++){
//            res += Math.abs(map.get(word.charAt(i)) - map.get(word.charAt(i-1)));
//        }
//        return res;
//    }

    // Array - beat 60%
    public int calculateTime(String keyboard, String word) {
        int res = 0;
        int[] dic = new int[keyboard.length()];
        for (int i = 0; i < keyboard.length(); i++){
            dic[keyboard.charAt(i) - 'a'] = i;
        }
        res += dic[word.charAt(0) - 'a'];
        for (int i = 1; i < word.length(); i++){
            res += Math.abs(dic[word.charAt(i)-'a'] - dic[word.charAt(i-1)-'a']);
        }
        return res;
    }
}
