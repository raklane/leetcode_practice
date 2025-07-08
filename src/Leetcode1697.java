import java.util.*;

public class Leetcode1697 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(distanceLimitedPathsExist(3, new int[][]{{0,1,2},{1,2,4},{2,0,8},{1,0,16}}, new int[][]{{0,1,2},{0,2,5}})));
    }

    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        Map<Integer, Map<Integer, Integer>> nodes = new HashMap<>();

        for(int[] edge : edgeList){
            Map<Integer, Integer> dest = nodes.getOrDefault(edge[0], new HashMap<>());
            int distance = dest.getOrDefault(edge[1], Integer.MAX_VALUE);
            int newDistance = Math.min(distance, edge[2]);
            dest.put(edge[1], newDistance);
            nodes.put(edge[0], dest);
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            Set<Integer> visited = new HashSet<>();
            if(checkPath(nodes, query[0], query[1], query[2], visited))
                result[i] = true;

        }
        return result;

    }

    private static boolean checkPath(Map<Integer, Map<Integer, Integer>> nodes, int src, int targetDes, int limit, Set<Integer> visited) {

        if(src == targetDes)
            return true;

        if(visited.contains(src))
            return false;

        Map<Integer, Integer> destinationMap = nodes.get(src);
        if(destinationMap == null)
            return false;

        visited.add(src);
        for(int dest : destinationMap.keySet()){
            int distance = destinationMap.get(dest);
            if(distance >= limit)
                continue;
            if(checkPath(nodes, dest, targetDes, limit, visited)){
                return true;
            }
        }
        return false;

    }


}
