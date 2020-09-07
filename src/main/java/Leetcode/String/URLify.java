package Leetcode.String;

public class URLify {
    public static void urlify(char[] charArr) {
        int len = charArr.length;
        int ind = len - 1, end = len - 1;
        while (charArr[end] == ' ') {
            end --;
        }
        for (int i = end; i >= 0; i--) {
            if (charArr[i] != ' ') {
                charArr[ind--] = charArr[i];
            } else {
                if (ind < len - 1 && charArr[ind+1] != '%') {
                    charArr[ind] = '0';
                    charArr[ind-1] = '2';
                    charArr[ind-2] = '%';
                    ind -= 3;
                }
            }
        }
        System.out.println(new String(charArr));
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        urlify(str.toCharArray());
    }
}
