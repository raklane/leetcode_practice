import java.util.*;

public class Leetcode310 {

    public static void main(String[] args){
        System.out.println(findMinHeightTrees(5, new int[][]{{0,1},{0,2},{0,3},{3,4}}));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {


        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges){
            List<Integer> nodes = adjList.getOrDefault(edge[0], new ArrayList<>());
            nodes.add(edge[1]);
            adjList.put(edge[0], nodes);
            nodes = adjList.getOrDefault(edge[1], new ArrayList<>());
            nodes.add(edge[0]);
            adjList.put(edge[1], nodes);
        }

        int[] iterations = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.offer(i);
            int iteration = 0;
            while (!queue.isEmpty()){
                iteration++;
                if(iteration > min){
                    iteration = Integer.MAX_VALUE;
                    break;
                }
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int top = queue.poll();
                    if(visited.contains(top))
                        continue;
                    visited.add(top);
                    List<Integer> list = adjList.get(top);
                    if(list == null)
                        continue;
                    for(int num : list){
                        if(!visited.contains(num))
                            queue.add(num);
                    }
                }
            }
            iterations[i] = iteration;
            min = Math.min(min, iteration);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < iterations.length; i++) {
            if(iterations[i] == min)
                ans.add(i);
        }
        return ans;

    }

}
