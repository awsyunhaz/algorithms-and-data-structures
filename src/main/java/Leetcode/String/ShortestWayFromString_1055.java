package Leetcode.String;

public class ShortestWayFromString_1055 {

    // O(MN)
    public int shortestWay(String source, String target) {
        int cnt = 0, i = 0, curr;
        while (i < target.length()){
            curr = 0;
            int start = i;
            cnt ++;
            while (i < target.length() && curr < source.length()){
                if (target.charAt(i) == source.charAt(curr)) i++;
                curr++;
            }
            if (i == start)
                return -1;
        }
        return cnt;
    }
}
