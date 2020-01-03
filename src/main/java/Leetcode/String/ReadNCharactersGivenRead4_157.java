package Leetcode.String;

public class ReadNCharactersGivenRead4_157 {
    /**
     * The read4 API is defined in the parent class Reader4.
     */
    int read4(char[] buf) {return 0;};

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer4 = new char[4];
        int pos = 0;
        while (pos < n) {
            int cnt = read4(buffer4);
            int len = Math.min(pos+cnt, n) - pos;
            for (int i = 0; i < len; i++) {
                buf[pos+i] = buffer4[i];
            }
            pos += len;
            if (len < 4) {
                return pos;
            }
        }
        return pos;
    }
}
