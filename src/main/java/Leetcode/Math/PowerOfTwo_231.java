package Leetcode.Math;

public class PowerOfTwo_231 {
//    public boolean isPowerOfTwo(int n) {
//        if (n <= 0) {
//            return false;
//        }
//        while (n > 1) {
//            if (n % 2 != 0) {
//                return false;
//            }
//            n /= 2;
//        }
//        return true;
//    }

    // bit comparison
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
}
