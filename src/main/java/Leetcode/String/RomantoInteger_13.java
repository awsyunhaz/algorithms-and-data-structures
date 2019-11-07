package Leetcode.String;

public class RomantoInteger_13 {
    // Check the previous char
    public int romanToInt(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                res += 1;
            } else if (c == 'V') {
                if (i >= 1 && s.charAt(i-1) == 'I') {
                    res += 3;
                } else {
                    res += 5;
                }
            } else if (c == 'X') {
                if (i >= 1 && s.charAt(i-1) == 'I') {
                    res += 8;
                } else {
                    res += 10;
                }
            } else if (c == 'L') {
                if (i >= 1 && s.charAt(i-1) == 'X') {
                    res += 30;
                } else {
                    res += 50;
                }
            } else if (c == 'C') {
                if (i >= 1 && s.charAt(i-1) == 'X') {
                    res += 80;
                } else {
                    res += 100;
                }
            } else if (c == 'D') {
                if (i >= 1 && s.charAt(i-1) == 'C') {
                    res += 300;
                } else {
                    res += 500;
                }
            } else if (c == 'M') {
                if (i >= 1 && s.charAt(i-1) == 'C') {
                    res += 800;
                } else {
                    res += 1000;
                }
            }
        }
        return res;
    }

    // Check the next char
//    public int romanToInt(String s) {
//        int len = s.length();
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            if (s.charAt(i) == 'I') {
//                if (i+1 < len && s.charAt(i+1) == 'V') {
//                    res += 4;
//                    i ++;
//                } else if (i+1 < len && s.charAt(i+1) == 'X') {
//                    res += 9;
//                    i ++;
//                } else {
//                    res += 1;
//                }
//            } else if (s.charAt(i) == 'X') {
//                if (i+1 < len && s.charAt(i+1) ==  'L') {
//                    res += 40;
//                    i ++;
//                } else if (i+1 < len && s.charAt(i+1) == 'C') {
//                    res += 90;
//                    i ++;
//                } else {
//                    res += 10;
//                }
//            } else if (s.charAt(i) == 'C') {
//                if (i+1 < len && s.charAt(i+1) == 'D') {
//                    res += 400;
//                    i ++;
//                } else if (i+1 < len && s.charAt(i+1) == 'M') {
//                    res += 900;
//                    i ++;
//                } else {
//                    res += 100;
//                }
//            } else if (s.charAt(i) == 'V') {
//                res += 5;
//            } else if (s.charAt(i) == 'X') {
//                res += 10;
//            } else if (s.charAt(i) == 'L') {
//                res += 50;
//            } else if (s.charAt(i) == 'C') {
//                res += 100;
//            } else if (s.charAt(i) == 'D') {
//                res += 500;
//            } else if (s.charAt(i) == 'M') {
//                res += 1000;
//            }
//        }
//        return res;
//    }
}
