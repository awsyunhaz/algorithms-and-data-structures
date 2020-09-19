package Leetcode.Graph.UnionFind;

public class GraphValidTree_261 {
    // DFS, O(V+E)
//    public boolean validTree(int n, int[][] edges) {
//        HashMap<Integer, List<Integer>> graph = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            graph.put(i, new ArrayList<>());
//        }
//        for (int[] e: edges) {
//            graph.get(e[0]).add(e[1]);
//            graph.get(e[1]).add(e[0]);
//        }
//        boolean[] visited = new boolean[n];
//        if (!traverse(graph, 0, visited)) {
//            return false;
//        }
//        for (boolean v: visited) {
//            if (!v) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean traverse(HashMap<Integer, List<Integer>> graph, int node, boolean[] visited) {
//        if (visited[node]) {
//            return false;
//        }
//        visited[node] = true;
//        for (int neigh: graph.get(node)) {
//            graph.get(neigh).remove(Integer.valueOf(node));
//            if (!traverse(graph, neigh, visited)) {
//                return false;
//            }
//        }
//        return true;
//    }


    // Union find, O(Elog*(V))
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] e: edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            // already connected -> loop
            if (root1 == root2) {
                return false;
            }
            // union
            roots[root1] = root2;
        }

        // only one island
        return edges.length == n-1;
    }

    public int find(int[] roots, int i) {
        if (roots[i] != i) {
            roots[i] = roots[roots[i]];
            return find(roots, roots[i]);
        }
        return i;
    }
}
