import java.util.*;

public class Leetcode207_1 {

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courses = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            courses.put(i,new LinkedList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];

            int a = prerequisite[0];
            int b = prerequisite[1];

            List<Integer> list = courses.get(a);
            if(!list.contains(b))
                list.add(b);
            courses.put(a,list);

        }

        List<Integer> courseToLook = new ArrayList<>();
        for(int key : courses.keySet()){
            if(courses.get(key).isEmpty()) continue;
            courseToLook.add(key);
            boolean canFinish = canFinishIterative(key, courseToLook, courses);
            if(!canFinish) return false;
            courseToLook.remove(courseToLook.size()-1);
        }
        return true;

    }

    public static boolean canFinishIterative(int course, List<Integer> courseToLook, Map<Integer, List<Integer>> courses){

        for(int key : courses.keySet()){

            if(key != course) continue;
            List<Integer> dependentCourses = courses.get(key);
            if(dependentCourses.isEmpty()) return true;
            for(int dependentCourse : dependentCourses){
                if(courseToLook.contains(dependentCourse)) return false;
                courseToLook.add(dependentCourse);
                boolean returnValue = canFinishIterative(dependentCourse, courseToLook, courses);
                if(returnValue == false) return false;
                courseToLook.remove(courseToLook.size()-1);
            }

        }
        return true;

    }




}
