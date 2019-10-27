package Leetcode.Math;

public class ConfusingNumber_1056 {
    public boolean confusingNumber(int N) {
        int[] arr = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int sum = 0, num = N;
        while (num > 0) {
            int val = num % 10;
            if (arr[val] == -1) {
                return false;
            }
            sum = sum * 10 + arr[val];
            num /= 10;
        }
        return sum == N? false: true;
    }
}
