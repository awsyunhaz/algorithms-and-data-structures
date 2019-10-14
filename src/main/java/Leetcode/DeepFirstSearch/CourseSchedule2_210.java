package Leetcode.DeepFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule2_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> pres = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        boolean[] requested = new boolean[numCourses];
        for (int[] course: prerequisites) {
            if (!pres.containsKey(course[0]))
                pres.put(course[0], new ArrayList<>());
            pres.get(course[0]).add(course[1]);
        }
        for (int course = 0; course < numCourses; course++) {
            if (!take(pres, res, course, requested))
                return new int[0];
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public boolean take(HashMap<Integer, List<Integer>> pres, List<Integer> res, int course, boolean[] requested) {
        if (!pres.containsKey(course)){
            if (!res.contains(course))
                res.add(course);
            return true;
        }
        if (requested[course])
            return false;
        requested[course] = true;
        for (int pre: pres.get(course)) {
            if (!take(pres, res, pre, requested))
                return false;
        }
        requested[course] = false;
        if (!res.contains(course))
            res.add(course);
        pres.remove(course);
        return true;
    }
}
