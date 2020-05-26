package Leetcode.Graph;

import java.util.*;

public class CourseSchedule_207 {

    // DFS + Pruning, O(E+V)
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
//        int[] inDegree = new int[numCourses];
//        Queue<Integer> queue = new ArrayDeque<>();
//        int n = numCourses;
//        for (int[] pre: prerequisites) {
//            if (!graph.containsKey(pre[0])) {
//                graph.put(pre[0], new LinkedList<>());
//            }
//            graph.get(pre[0]).add(pre[1]);
//        }
//        for (int i = 0; i < numCourses; i++) {
//            boolean[] requested = new boolean[numCourses];
//            if (!dfs(graph, i, requested)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean dfs(HashMap<Integer, LinkedList<Integer>> graph, int course, boolean[] requested) {
//        if (requested[course]) {
//            return false;
//        }
//        requested[course] = true;
//        if (graph.containsKey(course)) {
//            for (int next: graph.get(course)) {
//                if (!dfs(graph, next, requested)) {
//                    return false;
//                }
//            }
//        }
//        requested[course] = false;
//        graph.remove(course);
//        return true;
//    }

    // Topological sorting + BFS, O(E+V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int n = numCourses;
        for (int[] pre: prerequisites) {
            if (!graph.containsKey(pre[1])) {
                graph.put(pre[1], new LinkedList<>());
            }
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]] ++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                n --;
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (graph.containsKey(course)) {
                for (int c: graph.get(course)) {
                    inDegree[c] --;
                    if (inDegree[c] == 0) {
                        queue.offer(c);
                        n --;
                    }
                }
            }
        }
        return n == 0;
    }
}
