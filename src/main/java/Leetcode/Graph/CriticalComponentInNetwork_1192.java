package Leetcode.Graph;

import java.util.*;

public class CriticalComponentInNetwork_1192 {
    // Find if each edge is in a circle
    // O(E(V+E)), TLE
//    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//        Map<Integer, Set<Integer>> graph = new HashMap<>();
//        List<List<Integer>> res = new ArrayList<>();
//        for (List<Integer> edge: connections) {
//            if (!graph.containsKey(edge.get(0))) {
//                graph.put(edge.get(0), new HashSet<>());
//            }
//            if (!graph.containsKey(edge.get(1))) {
//                graph.put(edge.get(1), new HashSet<>());
//            }
//            graph.get(edge.get(0)).add(edge.get(1));
//            graph.get(edge.get(1)).add(edge.get(0));
//        }
//
//        for (List<Integer> edge: connections) {
//            int start = edge.get(0);
//            int end = edge.get(1);
//            graph.get(start).remove(end);
//            boolean[] visited = new boolean[n];
//            if (!isInCircle(graph, start, end, visited)) {
//                res.add(edge);
//            }
//            graph.get(start).add(end);
//        }
//        return res;
//    }
//
//    public boolean isInCircle(Map<Integer, Set<Integer>> graph, int curr, int target, boolean[] visited) {
//        if (curr == target) {
//            return true;
//        }
//        for (int next: graph.get(curr)) {
//            if (!visited[next]) {
//                visited[next] = true;
//                if (isInCircle(graph, next, target, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // Tarjan algorithm - O(V+E)
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n], low = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // build graph
        for (int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == 0) {
                dfs(i, low, disc, graph, res, i);
            }
        }
        return res;
    }

    int time = 0; // time when discover each vertex

    private void dfs(int curr, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int parent) {
        disc[curr] = low[curr] = ++time; // discover u
        for (int next: graph[curr]) {
            if (next == parent) {
                continue; // if parent vertex, ignore
            }
            if (disc[next] == 0) { // if not discovered
                dfs(next, low, disc, graph, res, curr);
                low[curr] = Math.min(low[curr], low[next]);
                if (low[next] > disc[curr]) {
                    // u - v is critical, there is no path for v to reach back to u or previous vertices of u
                    res.add(Arrays.asList(curr, next));
                }
            } else {
                // if v discovered and is not parent of u, update low[curr], cannot use low[next] because u is not subtree of v
                low[curr] = Math.min(low[curr], disc[next]);
            }
        }
    }
}
