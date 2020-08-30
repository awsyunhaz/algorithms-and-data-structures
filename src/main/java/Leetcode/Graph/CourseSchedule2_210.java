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
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int ind = 0;
        List<Set<Integer>> pres = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            pres.add(new HashSet<>());
        }
        for (int[] pre: prerequisites) {
            pres.get(pre[1]).add(pre[0]);
            indegree[pre[0]] ++;
        }
        List<Integer> courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                courses.add(i);
            }
        }
        int n = numCourses;
        while (!courses.isEmpty()) {
            n -= courses.size();
            List<Integer> newCourses = new ArrayList<>();
            for (int course: courses) {
                order[ind++] = course;
                for (int nextCourse: pres.get(course)) {
                    indegree[nextCourse] --;
                    if (indegree[nextCourse] == 0) {
                        newCourses.add(nextCourse);
                    }
                }
            }
            courses = newCourses;
        }
        return n == 0? order: new int[0];
    }
}
