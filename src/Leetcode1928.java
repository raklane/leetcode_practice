import java.util.*;

public class Leetcode1928 {

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edges){
            List<int[]> desTime = map.getOrDefault(edge[0], new ArrayList<>());
            desTime.add(new int[]{edge[1], edge[2]});
            map.put(edge[0], desTime);
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int distance = 0;
        int minCost = Integer.MAX_VALUE;
        queue.offer(new int[]{0, 0, passingFees[0]});

        while (!queue.isEmpty()){

            int[] top = queue.poll();
            int des = top[0];
            int cost = top[2];
            if(visited.contains(des) && cost>=minCost)
                continue;
            distance = top[1];
            List<int[]> destinationsFromHere = map.get(des);
            if(destinationsFromHere == null)
                continue;
            for (int[] destinationFromHere : destinationsFromHere){
                if(destinationFromHere[1] + distance > maxTime)
                    continue;
                queue.offer(new int[]{destinationFromHere[0], destinationFromHere[1] + distance, cost + passingFees[destinationFromHere[0]]});
            }

        }

        return -1;


    }

}
