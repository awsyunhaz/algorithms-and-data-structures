package Leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindCyclesInDirectedGraph {
    public static List<List<Integer>> findCycles(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
        }
        HashSet<Integer> visited = new HashSet<>();
        List<List<Integer>> cycles = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int node: graph.keySet()) {
            search(cycles, path, node, graph, visited);
        }
        return cycles;
    }

    public static void search(List<List<Integer>> cycles, List<Integer> path, int node, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited) {
        // find a new cycle
        if (path.contains(node)) {
            path.add(node);
            cycles.add(new ArrayList<>(path.subList(path.indexOf(node), path.size())));
            path.remove(path.size()-1);
            return;
        }
        if (visited.contains(node)) {
            return;
        }
        path.add(node);
        visited.add(node);
        for (int neighbor: graph.get(node)) {
            search(cycles, path, neighbor, graph, visited);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {2, 0}, {3, 1}, {4, 0}};
        for (List<Integer> list: findCycles(edges)) {
            System.out.println(list);
        }
    }
}
