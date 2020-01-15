package Leetcode.Graph;

public class RedundantConnection2_685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] roots = new int[edges.length+1];
        int[] res1 = new int[2], res2 = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            if (parent[to] == 0) {
                parent[to] = from;
            } else {
                // Node with two parents
                res1 = new int[]{parent[to], to};
                res2 = new int[]{from, to};
                // Invalid the second edge
                edges[i][1] = 0;
            }
        }

        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int[] e: edges) {
            if (e[1] == 0) {
                continue;
            }
            int root0 = findRoot(roots, e[0]);
            int root1 = findRoot(roots, e[1]);
            if (root0 != root1) {
                roots[e[1]] = roots[e[0]];
            } else {
                // Circle detected
                // If no node with two parents, return the edge to enable circle
                if (res1[1] == 0) {
                    return e;
                }
                // Still find circle with the second edge invalid
                // -> The first edge is in the circle, return the first edge
                return res1;
            }
        }
        // No circle detected, return the second edge of the node with two parents
        return res2;
    }

    public int findRoot(int[] roots, int i) {
        while (roots[i] != i) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}
