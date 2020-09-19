package Leetcode.Graph.UnionFind;

public class RedundantConnection_684 {

    // DFS - search cycle
    // O(VE)
//    public int[] findRedundantConnection(int[][] edges) {
//        HashMap<Integer, List<Integer>> graph = new HashMap<>();
//        for (int[] e: edges) {
//            if (!graph.containsKey(e[0])) {
//                graph.put(e[0], new ArrayList<>());
//            }
//            if (!graph.containsKey(e[1])) {
//                graph.put(e[1], new ArrayList<>());
//            }
//            graph.get(e[0]).add(e[1]);
//            graph.get(e[1]).add(e[0]);
//        }
//        for (int i = graph.size()-1; i >= 0; i--) {
//            boolean[] visited = new boolean[edges.length+1];
//            if (isInCircle(graph, visited, edges[i], edges[i][0])) {
//                return edges[i];
//            }
//        }
//        return null;
//    }
//
//    public boolean isInCircle(HashMap<Integer, List<Integer>> graph, boolean[] visited, int[] edge, int node) {
//        if (node == edge[1])
//            return true;
//        for (int next: graph.get(node)) {
//            if (node == edge[0] && next == edge[1])
//                continue;
//            if (!visited[next]) {
//                visited[next] = true;
//                if (isInCircle(graph, visited, edge, next))
//                    return true;
//            }
//        }
//        return false;
//    }

    // Union find - O(Elog*V)
    public int[] findRedundantConnection(int[][] edges) {
        int[] roots = new int[edges.length+1];
        for (int i = 1; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int[] e: edges) {
            int r0 = findRoot(roots, e[0]);
            int r1 = findRoot(roots, e[1]);
            if (r0 == r1) {
                return e;
            } else {
                roots[r1] = roots[r0];
            }
        }
        return null;
    }

    public int findRoot(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
