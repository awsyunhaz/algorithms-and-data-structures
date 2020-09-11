package algorithms.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

// In this problem, there are unlimited number of boxes
public class StackOfBoxes {
    // backtrack with memorization
//    public static int StackOfBoxes(int[][] boxes) {
//        int[][] memory = new int[boxes.length][3];
//        int maxHeight = 0;
//        for (int i = 0; i < boxes.length; i++) {
//            for (int j = 0; j < 3; j++) {
//                maxHeight = Math.max(maxHeight, createStack(boxes, i, memory, j));
//            }
//        }
//        return maxHeight;
//    }
//
//    public static int createStack(int[][] boxes, int bottomInd, int[][] memory, int rotateInd) {
//        if (memory[bottomInd][rotateInd] > 0) {
//            return memory[bottomInd][rotateInd];
//        }
//        int maxHeight = 0;
//        for (int i = 0; i < boxes.length; i++) {
//            for (int j = 0; j < 3; j++) {
//                // compare width and depth
//                if (boxes[i][(j+1) % 3] < boxes[bottomInd][(rotateInd+1) % 3]
//                        && boxes[i][(j+2) % 3] < boxes[bottomInd][(rotateInd+2) % 3]) {
//                    int height = createStack(boxes, i, memory, j);
//                    maxHeight = Math.max(maxHeight, height);
//                }
//            }
//        }
//        memory[bottomInd][rotateInd] = boxes[bottomInd][rotateInd] + maxHeight;
//        return memory[bottomInd][rotateInd];
//    }

    // DP
    public static int StackOfBoxes(int[][] boxes) {
        // all possible rotations
        int[][] allBoxes = new int[boxes.length*3][3];
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < 3; j++) {
                allBoxes[i*3+j][0] = boxes[i][j%3];
                allBoxes[i*3+j][1] = boxes[i][(1+j)%3];
                allBoxes[i*3+j][2] = boxes[i][(2+j)%3];
            }
        }
        Arrays.sort(allBoxes, (a, b) -> (b[1]*b[2] - a[1]*a[2]));
        int[] dp = new int[allBoxes.length];
        int res = 0;
        for (int i = 0; i < allBoxes.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (allBoxes[i][1] < allBoxes[j][1] && allBoxes[i][2] < allBoxes[j][2]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + allBoxes[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] boxes = { {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} };
        System.out.println(StackOfBoxes(boxes));
    }
}
