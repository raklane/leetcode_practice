import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode207_2 {

    public static void main(String[] args){
        System.out.println(canFinish(2, new int[][]{{1,0}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>>  adjecencyMap = new HashMap<>();

        for(int[] prerequisite : prerequisites){
            Set<Integer> set = adjecencyMap.getOrDefault(prerequisite[0], new HashSet<>());
            set.add(prerequisite[1]);
            adjecencyMap.put(prerequisite[0], set);
        }
        Set<Integer> coursesTaken = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            coursesTaken.add(i);
        }
        for(int key : adjecencyMap.keySet()){
            coursesTaken.remove(key);
        }

        for(int key : adjecencyMap.keySet()){
            if(coursesTaken.contains(key))
                continue;
            Set<Integer> currentCourses = new HashSet<>();
            currentCourses.add(key);
            Set<Integer> dependentCourses = adjecencyMap.get(key);
            if(!dfs(adjecencyMap, coursesTaken, currentCourses, dependentCourses))
                return false;
            else
                coursesTaken.add(key);
        }
        if(coursesTaken.size() == numCourses)
            return true;
        return false;

    }

    private static boolean dfs(Map<Integer, Set<Integer>>  adjecencyMap, Set<Integer> coursesTaken, Set<Integer> currentCourses, Set<Integer> dependentCourses){

        for(int dependentCourse : dependentCourses){
            if(coursesTaken.contains(dependentCourse))
                continue;
            if(currentCourses.contains(dependentCourse))
                return false;
            currentCourses.add(dependentCourse);
            if(!dfs(adjecencyMap, coursesTaken, currentCourses, adjecencyMap.get(dependentCourse)))
                return false;
            coursesTaken.add(dependentCourse);
        }
        return true;

    }

}
