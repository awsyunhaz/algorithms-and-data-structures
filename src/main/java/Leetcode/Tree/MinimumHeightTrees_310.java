package Leetcode.Tree;

import java.util.*;

public class MinimumHeightTrees_310 {
    // DFS - O(V^2), TLE
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        if (n == 1) {
//            return Arrays.asList(0);
//        }
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
//        int minHeight = Integer.MAX_VALUE;
//        List<Integer> res = new ArrayList<>();
//        for (int root: graph.keySet()) {
//            boolean[] visited = new boolean[n];
//            visited[root] = true;
//            int height = dfs(graph, root, visited);
//            if (height < minHeight) {
//                res = new ArrayList<>();
//                minHeight = height;
//            }
//            if (height == minHeight) {
//                res.add(root);
//            }
//        }
//        return res;
//    }
//
//    public int dfs(HashMap<Integer, List<Integer>> graph, int node, boolean[] visited) {
//        int depth = 0;
//        for (int next: graph.get(node)) {
//            if (!visited[next]) {
//                visited[next] = true;
//                depth = Math.max(depth, dfs(graph, next, visited));
//            }
//        }
//        return depth+1;
//    }

    // BFS, O(n)
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        if (n == 1) {
//            return Arrays.asList(0);
//        }
//        HashMap<Integer, List<Integer>> graph = new HashMap<>();
//        int[] degree = new int[n];
//        for (int[] e: edges) {
//            if (!graph.containsKey(e[0])) {
//                graph.put(e[0], new ArrayList<>());
//            }
//            if (!graph.containsKey(e[1])) {
//                graph.put(e[1], new ArrayList<>());
//            }
//            graph.get(e[0]).add(e[1]);
//            graph.get(e[1]).add(e[0]);
//            degree[e[0]] ++;
//            degree[e[1]] ++;
//        }
//        Queue<Integer> queue = new ArrayDeque<>();
//        for (int i = 0; i < degree.length; i++) {
//            if (degree[i] == 1) {
//                queue.add(i);
//            }
//        }
//        List<Integer> res = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            res = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int node = queue.poll();
//                degree[node] --;
//                res.add(node);
//                for (int next: graph.get(node)) {
//                    if (degree[next] == 0) {
//                        continue;
//                    }
//                    if (degree[next] == 2) {
//                        queue.add(next);
//                    }
//                    degree[next] --;
//                }
//            }
//        }
//        return res;
//    }

    // Similar to BFS, cutting from leaves (easy to understand)
    // O(n)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (true) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int node: leaves) {
                for (int next: graph.get(node)) {
                    if (graph.get(next).size() == 0) {
                        continue;
                    }
                    graph.get(next).remove(node);
                    if (graph.get(next).size() == 1) {
                        newLeaves.add(next);
                    }
                }
            }
            if (newLeaves.isEmpty()) {
                return leaves;
            }
            leaves = newLeaves;
        }
    }
}
