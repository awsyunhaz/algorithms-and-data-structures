package Leetcode.String;

public class ExcelSheetColumnTitile_168 {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            char c = (char) ((n-1)%26 + 'A');
            sb.insert(0, c);
            n = (n-1)/26;
        }
        return sb.toString();
    }
}
