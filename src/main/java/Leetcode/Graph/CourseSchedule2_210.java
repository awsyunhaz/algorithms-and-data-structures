package Leetcode.Graph;

import java.util.*;

public class CourseSchedule2_210 {

    // DFS with memory, from course to prerequisite courses
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        HashMap<Integer, HashSet<Integer>> preMap = new HashMap<>();
//        HashSet<Integer> taken = new HashSet<>();
//        List<Integer> order = new ArrayList<>();
//        boolean[] requested = new boolean[numCourses];
//        for (int[] pre: prerequisites) {
//            if (!preMap.containsKey(pre[0])) {
//                preMap.put(pre[0], new HashSet<>());
//            }
//            preMap.get(pre[0]).add(pre[1]);
//        }
//        for (int course = 0; course < numCourses; course++) {
//            if (!takeCourse(preMap, taken, course, order, requested)) {
//                return new int[0];
//            }
//        }
//        int[] res = new int[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            res[i] = order.get(i);
//        }
//        return res;
//
//    }
//
//    public boolean takeCourse(HashMap<Integer, HashSet<Integer>> preMap, HashSet<Integer> taken,
//                              int course, List<Integer> order, boolean[] requested) {
//        // Courses without prerequisite
//        if (!preMap.containsKey(course)) {
//            if (!taken.contains(course)) {
//                taken.add(course);
//                order.add(course);
//            }
//            return true;
//        }
//        // If the course is already requested by other courses
//        if (requested[course]) {
//            return false;
//        }
//        requested[course] = true;
//        for (int preCourse: preMap.get(course)) {
//            if (!takeCourse(preMap, taken, preCourse, order, requested)) {
//                return false;
//            }
//        }
//        // After taking all prerequisites, we can take the course
//        taken.add(course);
//        order.add(course);
//        // The course can now be removed from prequisite map
//        preMap.remove(course);
//        return true;
//    }

    // Topological sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> nextCourse = new HashMap<>();
        int[] inCnt = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();
        for (int[] pre: prerequisites) {
            if (!nextCourse.containsKey(pre[1])) {
                nextCourse.put(pre[1], new HashSet<>());
            }
            nextCourse.get(pre[1]).add(pre[0]);
            inCnt[pre[0]] ++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inCnt[i] == 0) {
                queue.offer(i);
                order.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (nextCourse.containsKey(course)) {
                for (int c: nextCourse.get(course)) {
                    inCnt[c] --;
                    if (inCnt[c] == 0) {
                        queue.offer(c);
                        order.add(c);
                    }
                }
            }
        }
        if (order.size() == numCourses) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = order.get(i);
            }
            return res;
        }
        return new int[0];
    }
}
