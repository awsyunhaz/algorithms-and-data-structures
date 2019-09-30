package Leetcode.Google;

public class CompareStrings {
    public int[] compare(String A, String B) {
        String[] strA = A.split(",");
        String[] strB = B.split(",");
        int[] freqA = new int[strA.length];
        int[] freqB = new int[strB.length];
        int[] res = new int[strB.length];

        countMinChar(strA, freqA);
        countMinChar(strB, freqB);
        for (int i = 0; i < freqB.length; i++){
            int cnt = 0;
            for (int j = 0; j < freqA.length; j++){
                if (freqA[j] < freqB[i])
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

    public static void main(String args[]){
        CompareStrings obj = new CompareStrings();
        int[] res = obj.compare("abcd,aabc,bd", "aaa,aa");
        for (int num: res)
            System.out.println(num);
    }
}
