package Leetcode.Backtracking;

public class ConfusingNumber2_1088 {
    private int counter;
    private int[] nums = {0, 1, 6, 8, 9};

    public int confusingNumberII(int N) {
        int[] first = {1, 6, 8, 9};
        counter = 0;
        for (int num: first) {
            backtrack(N, num);
        }
        return counter;
    }

    public void backtrack(int N, int curr) {
        if (curr > N) {
            return;
        }
        if (isConfusing(curr)) {
            counter ++;
        }
        if (curr > 100000000) {
            return;
        }
        for (int num: nums) {
            backtrack(N, curr*10+num);
        }
    }

    public boolean isConfusing(int num) {
        int[] map = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int sum = 0, tmp = num;
        while (tmp > 0) {
            sum = sum*10 + map[tmp%10];
            tmp /= 10;
        }
        return sum != num;
    }
}
