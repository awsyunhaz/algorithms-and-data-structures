package Leetcode.String;

public class CompareStringsbyFrequencyoftheSmallestCharacter_1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freqA = new int[queries.length];
        int[] freqB = new int[words.length];
        int[] res = new int[queries.length];

        countMinChar(queries, freqA);
        countMinChar(words, freqB);
        for (int i = 0; i < freqA.length; i++){
            int cnt = 0;
            for (int j = 0; j < freqB.length; j++){
                if (freqA[i] < freqB[j])
                    cnt ++;
            }
            res[i] = cnt;
        }
        return res;
    }

    public void countMinChar(String[] str, int[] freq){
        for (int i = 0; i < str.length; i++){
            char minChar = 'z';
            int cnt = 0;
            for (char c: str[i].toCharArray()){
                if (c < minChar){
                    minChar = c;
                    cnt = 0;
                }
                if (c == minChar) {
                    cnt ++;
                }
            }
            freq[i] = cnt;
        }
    }
}
