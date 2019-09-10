package Leetcode.String;

class VerifyingAnAlienDictionary_953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i)-'a'] = i;
        }
        for (int i = 0; i < words.length-1; i++){
            String word1 = words[i], word2 = words[i+1];
            int j = 0, len1 = word1.length(), len2 = word2.length();
            while (j < Math.min(len1, len2) && word1.charAt(j) == word2.charAt(j))
                j++;
            if (j < Math.min(len1, len2) && orderMap[word1.charAt(j)-'a'] > orderMap[word2.charAt(j)-'a']
                    || j == Math.min(len1, len2) && len1 > len2){
                return false;
            }
        }
        return true;
    }
}