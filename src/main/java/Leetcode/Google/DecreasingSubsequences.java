package Leetcode.Google;

import java.util.ArrayList;
import java.util.List;

public class DecreasingSubsequences {
//    public int decreasingSubsequences (int[] seq){
//        boolean[] visited = new boolean[seq.length];
//        int size = seq.length, res = 0;
//        while (size > 0){
//            res += 1;
//            int max = Integer.MAX_VALUE;
//            for (int i = 0; i < seq.length; i ++) {
//                if (!visited[i] && seq[i] < max) {
//                    visited[i] = true;
//                    size--;
//                    max = seq[i];
//                }
//            }
//        }
//        return res;
//    }

    public int decreasingSubsequences (int[] seq){
        int[] smallest = new int[seq.length];
        int size = 0;
        for (int num: seq){
            int i = 0;
            while (i < size && num >= smallest[i]) i++;
            if (i == size) size++;
            smallest[i] = num;
        }
        return size;
    }

    public static void main(String[] args){
//        test case: [5, 2, 4, 3, 1, 6], [2, 9, 12, 13, 4, 7, 6, 5, 10], [1, 1, 1]
        int[] seq = new int[]{5, 2, 4, 3, 1, 6};
        DecreasingSubsequences obj = new DecreasingSubsequences();
        int res = obj.decreasingSubsequences(seq);
        System.out.println(res);
    }
}
