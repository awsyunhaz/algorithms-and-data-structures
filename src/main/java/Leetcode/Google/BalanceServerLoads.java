package Leetcode.Google;
import java.util.Scanner;
import java.util.stream.Stream;

public class BalanceServerLoads {
    static int solution(Integer[] loads) {
        // put your solution here
        int sum = 0;
        for (int load: loads){
            sum += load;
        }

        int[][] f = new int[loads.length+1][sum/2+1];
        for (int i = 1; i <= loads.length; i++){
            for (int j = 1; j <= sum/2; j++){
                if (j < loads[i-1])
                    f[i][j] = f[i-1][j];
                else
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-loads[i-1]] + loads[i-1]);
            }
        }
        int maxLoad = f[loads.length][sum/2];
        return Math.abs(sum - 2*maxLoad);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] loads = getIntegerArray(in.next());

        System.out.print(solution(loads));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}
