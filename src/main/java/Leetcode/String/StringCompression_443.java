package Leetcode.String;

public class StringCompression_443 {
    public int compress(char[] chars) {
        char c = chars[0];
        int cnt = 0, pos = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                cnt ++;
            } else {
                chars[pos++] = c;
                if (cnt >= 2) {
                    String str = Integer.toString(cnt);
                    for (char digit: str.toCharArray()) {
                        chars[pos++] = digit;
                    }
                }
                c = chars[i];
                cnt = 1;
            }
        }

        chars[pos++] = c;
        if (cnt >= 2) {
            String str = Integer.toString(cnt);
            for (char digit: str.toCharArray()) {
                chars[pos++] = digit;
            }
        }
        return pos;
    }
}
