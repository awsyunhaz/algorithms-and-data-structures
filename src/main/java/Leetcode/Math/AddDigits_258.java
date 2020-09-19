package Leetcode.Math;

public class AddDigits_258 {
//    public int addDigits(int num) {
//        while (num / 10 > 0) {
//            int numNext = 0;
//            while (num > 0) {
//                numNext += num % 10;
//                num /= 10;
//            }
//            num = numNext;
//        }
//        return num;
//    }

    // O(1) time
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0? 9: num % 9;
    }
}
