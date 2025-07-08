import java.util.*;

public class Leetcode2050 {

    public static void main(String[] args){
        System.out.println(minimumTime(9, new int[][]{{2,7},{2,6},{3,6},{4,6},{7,6},{2,1},{3,1},{4,1},{6,1},{7,1},{3,8},{5,8},{7,8},{1,9},{2,9},{6,9},{7,9}},
                new int[]{9,5,9,5,8,7,7,8,4}));
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] relation : relations){
            Set<Integer> set = map.getOrDefault(relation[1], new HashSet<>());
            set.add(relation[0]);
            map.put(relation[1], set);
        }

        Set<Integer> currentCoursesInProgress = new HashSet<>();
        Set<Integer> coursesTaken = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if(!map.containsKey(i)) {
                currentCoursesInProgress.add(i);
            }
        }

        int totalTime = 0;
        while (!currentCoursesInProgress.isEmpty()){

            int minAmongCurrent = Integer.MAX_VALUE;
            for(int course : currentCoursesInProgress){
                minAmongCurrent = Math.min(minAmongCurrent, time[course-1]);
            }
            totalTime += minAmongCurrent;

            for(int currentCourse : currentCoursesInProgress){
                time[currentCourse-1] -= minAmongCurrent;
            }
            for (int i = 0; i < time.length; i++) {
                if(time[i] == 0){
                    coursesTaken.add(i+1);
                    currentCoursesInProgress.remove((Integer) i+1);
                }
            }
            for(Set<Integer> set : map.values()){
                set.removeAll(coursesTaken);
            }
            for(int key : map.keySet()){
                if(map.get(key).size() == 0 && !coursesTaken.contains(key))
                    currentCoursesInProgress.add(key);
            }
        }

        return  totalTime;

    }

}
