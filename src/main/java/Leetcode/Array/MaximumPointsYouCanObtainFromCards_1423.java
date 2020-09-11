package Leetcode.Array;

public class MaximumPointsYouCanObtainFromCards_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        for (int i = k-1, j = cardPoints.length-1; i >= 0; i--, j--) {
            sum = sum - cardPoints[i] + cardPoints[j];
            max = Math.max(max, sum);
        }
        return max;
    }
}
