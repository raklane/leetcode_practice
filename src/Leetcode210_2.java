import java.util.*;

public class Leetcode210_2 {

    public static void main(String[] args) {
        int[] ans = findOrder(6,new int[][]{{2,3},{1,2},{0,1},{0,4},{4,5},{5,1}});
        System.out.println("Rakesh");
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i,new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            List<Integer> currentPrequisites = map.get(prerequisite[0]);
            currentPrequisites.add(prerequisite[1]);
            map.put(prerequisite[0], currentPrequisites);
        }

        int numberOfPrerequisiteCourses = 0;
        List<Integer> coursesTaken = new ArrayList<>();
        while (coursesTaken.size()<numCourses && numberOfPrerequisiteCourses<numCourses){
            for(int key : map.keySet()){
                if(coursesTaken.contains(key))
                    continue;
                List<Integer> prerequisiteCourses = map.get(key);
                if(prerequisiteCourses.size() == numberOfPrerequisiteCourses){
                    for(int prerequisiteCourse : prerequisiteCourses){
                        List<Integer> dependentCourses = new ArrayList<>();
                        if(!takeCourse(map, prerequisiteCourse,coursesTaken,dependentCourses))
                            return new int[0];
                    }
                }else
                    continue;
                if(!coursesTaken.contains(key))
                    coursesTaken.add(key);
            }
            numberOfPrerequisiteCourses++;
        }

        return coursesTaken.stream().mapToInt(i -> i).toArray();

    }

    private static boolean takeCourse(Map<Integer, List<Integer>> map, int prerequisiteCourse,
                                      List<Integer> coursesTaken, List<Integer> dependentCourses) {

        if(coursesTaken.contains(prerequisiteCourse))
            return true;

        if(dependentCourses.contains(prerequisiteCourse))
            return false;

        List<Integer> newPrerequisiteCourses = map.get(prerequisiteCourse);
        if(newPrerequisiteCourses == null){
            coursesTaken.add(prerequisiteCourse);
            return true;
        }
        dependentCourses.add(prerequisiteCourse);
        for(int newPrerequisiteCourse : newPrerequisiteCourses){
            if(!takeCourse(map,newPrerequisiteCourse,coursesTaken,dependentCourses))
                return false;
        }
        dependentCourses.remove((Integer) prerequisiteCourse);
        if(coursesTaken.contains(prerequisiteCourse))
            coursesTaken.add(prerequisiteCourse);
        return true;

    }

}
