package leetcode.String;

public class LengthofLastWord_58 {
    public int lengthOfLastWord(String s) {
        String[] list = s.split(" ");
        if (list.length==0)
            return 0;
        return list[list.length-1].length();
    }
}
