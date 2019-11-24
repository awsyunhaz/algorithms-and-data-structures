package Leetcode.Graph;

public class IsGraphBipartite_785 {
    public boolean isBipartite(int[][] graph) {
        int[] label = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (label[i] == 0) {
                label[i] = 1;
                if (!assign(graph, label, i))
                    return false;
            }
        }
        return true;
    }

    public boolean assign(int[][] graph, int[] label, int i) {
        for (int v: graph[i]) {
            if (label[v] != 0) {
                if (label[i] == label[v])
                    return false;
                continue;
            }
            else {
                label[v] = -label[i];
                if (!assign(graph, label, v)) {
                    return false;
                }
            }
        }
        return true;
    }
}
