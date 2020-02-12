package Leetcode.Bit;

public class BitwiseANDofNumberRange_201 {
//    public int rangeBitwiseAnd(int m, int n) {
//        int b = 0;
//        while (m < n && m > 0) {
//            m &= (m+1);
//            while (m > 0 && (m & 1) == 0) {
//                m >>= 1;
//                n >>= 1;
//                b ++;
//            }
//
//        }
//        return m << b;
//    }

    // Even simpler solution
    public int rangeBitwiseAnd(int m, int n) {
        int b = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            b ++;
        }
        return m << b;
    }
}
