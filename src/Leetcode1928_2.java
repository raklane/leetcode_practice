import java.util.*;

public class Leetcode1928_2 {

    public static void main(String[] args){
        System.out.println(minCost(100, new int[][]{{0,1,100}}, new int[]{2,5}));
    }

    public static int minCost(int maxTime, int[][] edges, int[] passingFees) {

        Set<Integer> uniqueNodes = new HashSet<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edges){
            List<int[]> desTime = map.getOrDefault(edge[0], new ArrayList<>());
            desTime.add(new int[]{edge[1], edge[2]});
            map.put(edge[0], desTime);

            desTime = map.getOrDefault(edge[1], new ArrayList<>());
            desTime.add(new int[]{edge[0], edge[2]});
            map.put(edge[1], desTime);
            uniqueNodes.add(edge[0]);
            uniqueNodes.add(edge[1]);
        }
        return helper(maxTime, map, passingFees, 0, uniqueNodes.size(), 0, 0, new HashSet<>());
    }

    public static int helper(int maxTime, Map<Integer, List<int[]>> map, int[] passingFees, int currentNode, int n, int currentDistance, int currentFee, Set<Integer> visited){

        if(visited.contains(currentNode))
            return -1;

        if(currentNode == n-1){
            if(currentDistance <= maxTime)
                return currentFee + passingFees[currentNode];
            return -1;
        }

        visited.add(currentNode);
        currentFee = currentFee + passingFees[currentNode];
        List<int[]> destinations = map.get(currentNode);
        int minFee = Integer.MAX_VALUE;
        if(destinations == null)
            return -1;
        for (int[] destination : destinations){

            int fee = helper(maxTime, map, passingFees, destination[0], n, currentDistance + destination[1], currentFee, visited);
            if(fee != -1)
                minFee = Math.min(minFee, fee);

        }
        if(minFee != Integer.MAX_VALUE)
            return minFee;
        return -1;

    }

}
