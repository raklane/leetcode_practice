import java.util.*;

public class Leetcode815_3 {

    public static void main(String[] args){
        System.out.println(numBusesToDestination(new int[][]{{1,2,7},{3,6,7}}, 1, 6));
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {

        if(source == target)
            return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] route : routes){
            for (int i = 0; i < route.length; i++) {
                List<Integer> toStop = map.getOrDefault(route[i], new ArrayList<>());
                int j = i+1;
                while (j%route.length != i){
                    toStop.add(route[j%route.length]);
                    j++;
                }
                map.put(route[i], toStop);
            }
        }

        if(map.get(source) == null)
            return -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        int busChange = 0;
        Set<Integer> stopsVisited = new HashSet<>();

        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                if(stopsVisited.contains(currentStop))
                    continue;
                stopsVisited.add(currentStop);
                if(currentStop == target)
                    return busChange;
                List<Integer> list = map.get(currentStop);
                for (int j = 0; j < list.size(); j++) {
                    queue.offer(list.get(j));
                }
            }
            busChange++;

        }
        return -1;

    }



}
