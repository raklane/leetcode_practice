import java.util.*;

public class Leetcode210 {

    public static void main(String[] args) {
        int[] ans = findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            List<Integer> currentPrequisites = map.get(prerequisite[0]);
            if(currentPrequisites == null)
                currentPrequisites = new ArrayList<>();
            currentPrequisites.add(prerequisite[1]);
            map.put(prerequisite[0], currentPrequisites);
        }

        boolean[] coursesCovered = new boolean[numCourses];
        List<Integer> coursesTaken = new ArrayList<>();
        boolean ans = true;
        for (int i = 0; i < numCourses; i++) {
            ans = ans && coursesSchedule(map,coursesCovered,coursesTaken, new ArrayList<>(),i, true);
        }
        if(ans)
            return coursesTaken.stream().mapToInt(Integer::intValue).toArray();
        else
            return new int[numCourses];

    }

    public static boolean coursesSchedule(Map<Integer, List<Integer>> map, boolean[] coursesCovered,
                                          List<Integer> coursesTaken, List<Integer> dependentCourses, int currentCourse, boolean ans){

        if(coursesTaken.contains(currentCourse))
            return true;
        List<Integer> prerequisites = map.get(currentCourse);
        if(prerequisites == null){
            if(!coursesTaken.contains(currentCourse))
                coursesTaken.add(currentCourse);
            return true;
        }
        for(int prerequisiteCourse : prerequisites){
            if(dependentCourses.contains(prerequisiteCourse))
                return false;
            else {
                dependentCourses.add(currentCourse);
                ans = ans && coursesSchedule(map,coursesCovered,coursesTaken,dependentCourses,prerequisiteCourse,true);
                dependentCourses.remove((Integer) currentCourse);
                if(!ans)
                    return false;
            }

        }
        if(!ans)
            if(!coursesTaken.contains(currentCourse)){
                coursesTaken.add(currentCourse);
            }
        return true;
    }

}
