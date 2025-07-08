import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode207 {

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Boolean> courses = new HashMap<Integer,Boolean>();
        for (int i = 0; i < numCourses; i++) {
            courses.put(i,false);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];

            int a = prerequisite[0];
            int b = prerequisite[1];
            Set<Integer> indexesCovered = new HashSet<Integer>();

            if(!courses.get(a)){
                indexesCovered.add(i);
                boolean canFinishThisCourse = canFinishIterative(prerequisites, courses, indexesCovered, b);
                if(!canFinishThisCourse)
                    return false;
                courses.put(a,true);
                indexesCovered.remove(i);
            }
        }
        for(boolean coveredFlag : courses.values()){
            if(!coveredFlag)
                return false;
        }
        return true;
    }

    public static boolean canFinishIterative(int[][] prerequisites, Map<Integer,Boolean> courses, Set<Integer> indexesCovered, int currentCourse){

        if(courses.get(currentCourse))
            return true;
        boolean result = true;
        for (int i = 0; !(indexesCovered.contains(i)) && i < prerequisites.length; i++) {
            indexesCovered.add(i);
            int[] prerequisite = prerequisites[i];
            if(prerequisite[0] == currentCourse){
                result = result && canFinishIterative(prerequisites, courses, indexesCovered, prerequisite[1]);
            }
            indexesCovered.remove(i);
        }
        return result;

    }


}
