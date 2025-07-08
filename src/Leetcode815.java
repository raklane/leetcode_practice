import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode815 {
    public static void main(String[] args){
        System.out.println(numBusesToDestination(new int[][]{{1,2,7},{3,6,7}}, 1, 6));
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {

        Queue<Integer> currentStops = new LinkedList<>();
        currentStops.add(source);
        Set<Integer> busesVisited = new HashSet<>();
        int numberOfHops = 0;
        while (!currentStops.isEmpty()){
            if(currentStops.contains(target))
                return numberOfHops;
            int numberOfCurrentStops = currentStops.size();
            numberOfHops++;
            for (int i = 0; i < numberOfCurrentStops; i++) {
                int currentStop = currentStops.poll();
                addStopsFromCurrentStop(routes, currentStop, currentStops, busesVisited);
            }
        }
        return -1;
    }

    private static void addStopsFromCurrentStop(int[][] routes, int currentStop, Queue<Integer> currentStops, Set<Integer> busesVisited){
        for (int i = 0; i < routes.length; i++) {
            if(busesVisited.contains(i))
                continue;
            int[] route = routes[i];
            boolean routeHasCurrentStops = false;
            for(int routeStop : route){
                if(routeStop == currentStop)
                    routeHasCurrentStops=true;
            }
            if(routeHasCurrentStops){
                for (int routeStop : route)
                    if(routeStop != currentStop)
                        currentStops.add(routeStop);
                busesVisited.add(i);
            }
        }
    }

}
