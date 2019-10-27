package Leetcode.String;

public class StudentAttendanceRecord_551 {
    public boolean checkRecord(String s) {
        boolean hasA = false;
        int contL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                contL ++;
                if (contL > 2)
                    return false;
            } else {
                contL = 0;
                if (s.charAt(i) == 'A'){
                    if (hasA)
                        return false;
                    hasA = true;
                }
            }
        }
        return true;
    }
}
