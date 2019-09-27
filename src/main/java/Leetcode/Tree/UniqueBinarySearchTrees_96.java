package Leetcode.Tree;

public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++){
            int count = 0;
            for (int j = 1; j <= i; j++)
                count += f[j-1]*f[i-j];
            f[i] = count;
        }
        return f[n];
    }

    public static void main(String[] args){
        UniqueBinarySearchTrees_96 obj = new UniqueBinarySearchTrees_96();
        for (int i = 1; i <= 8; i ++) {
            System.out.println(obj.numTrees(i));
        }
    }
}
