import java.util.*;

public class Leetcode261_2 {

    public boolean validTree(int n, int[][] edges) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            map.get(x).add(y);
            map.get(y).add(x);
        }

        Set<Integer> visitedNodes = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                if(visitedNodes.contains(top))
                    return false;
                visitedNodes.add(top);
                Set<Integer> neighbors = map.get(top);
                for(int neighbor : neighbors){
                    queue.offer(neighbor);
                    map.get(neighbor).remove((Integer) top);
                }
            }
        }
        if(visitedNodes.size() == n)
            return true;
        return false;

    }

}
