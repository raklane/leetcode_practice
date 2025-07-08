import java.util.*;

public class Leetcode734 {

    public static void main(String[] args){
        System.out.println(networkDelayTime(new int[][]{{1,2,1},{2,1,3}}, 2, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times){
            List<int[]> timeToNodes = graph.getOrDefault(time[0], new ArrayList<>());
            timeToNodes.add(new int[]{time[1], time[2]});
            graph.put(time[0], timeToNodes);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        minHeap.offer(new int[]{k,0});

        Set<Integer> visited = new HashSet<>();
        int distance = 0;

        while (!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int dest = top[0];
            if(visited.contains(dest))
                continue;
            distance = top[1];
            visited.add(dest);
            List<int[]> destFromHere = graph.get(dest);
            if(destFromHere == null)
                continue;
            for(int[] distancesFromHere : destFromHere){
                int newDistance = distance + distancesFromHere[1];
                minHeap.offer(new int[]{distancesFromHere[0], newDistance});
            }
        }
        return visited.size() == n ? distance : -1;

    }


}
