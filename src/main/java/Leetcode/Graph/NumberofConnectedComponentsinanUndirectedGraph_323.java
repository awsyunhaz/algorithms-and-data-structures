package Leetcode.Graph;

public class NumberofConnectedComponentsinanUndirectedGraph_323 {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        int res = n;
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] e: edges) {
            int r1 = findRoot(root, e[0]);
            int r2 = findRoot(root, e[1]);
            if (r1 != r2) {
                root[r2] = r1;
                res --;
            }
        }
        return res;
    }

    public int findRoot(int[] root, int ind) {
        while (root[ind] != ind) {
            root[ind] = root[root[ind]];
            ind = root[ind];
        }
        return ind;
    }
}
