package Leetcode.BitManipulation;

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int cont = 0;
        for (int d: data) {
            if (cont == 0) {
                int pos = 7, mask = 0xff;
                while (d >> pos == 1) {
                    cont ++;
                    mask >>= 1;
                    d = d & mask;
                    pos --;
                }
                // 4 bytes at most
                if (cont >= 5) {
                    return false;
                }
                if (cont >= 2) {
                    cont --;
                }
            } else {
                // start with 10
                int mask = 0xff;
                if (d >> 7 != 1) {
                    return false;
                }
                mask >>= 1;
                d = d & mask;
                if (d >> 6 != 0) {
                    return false;
                }
                cont --;
            }
        }
        return cont == 0;
    }
}
