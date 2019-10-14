package Leetcode.DeepFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> pres = new HashMap<>();
        boolean[] requested = new boolean[numCourses];
        for (int[] course: prerequisites) {
            if (!pres.containsKey(course[0])) {
                pres.put(course[0], new ArrayList<>());
            }
            pres.get(course[0]).add(course[1]);
        }
        for (int course = 0; course < numCourses; course ++) {
            if (!takeCourse(course, pres, requested)) {
                return false;
            }
        }
        return true;
    }

    public boolean takeCourse(int course, HashMap<Integer, List<Integer>> pres, boolean[] requested) {
        if (!pres.containsKey(course))
            return true;
        if (requested[course] == true) {
            return false;
        }
        requested[course] = true;

        for (int pre: pres.get(course)) {
            if (!takeCourse(pre, pres, requested))
                return false;
        }
        requested[course] = false;
        // Prune as we know that course can be satisfied
        pres.remove(course);
        return true;
    }
}
