import java.util.*;

public class Leetcode886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        if(dislikes.length == 0)
            return true;

        int[] people = new int[n+1];
        Arrays.fill(people, -1);

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] dislike : dislikes){
            int i = dislike[0];
            int j = dislike[1];
            if(map.get(i) == null)
                map.put(i, new HashSet<>());
            if(map.get(j) == null)
                map.put(j, new HashSet<>());
            map.get(i).add(j);
            map.get(j).add(i);
        }

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1){
                if(!bfs(i, map, people))
                    return false;
            }
        }
        return true;

    }

    private boolean bfs(int source, Map<Integer, Set<Integer>> map, int[] people){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        people[source] = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                Set<Integer> set = map.get(top);
                if(set == null)
                    continue;
                for(int num : set){
                    if(people[num] == people[top])
                        return false;
                    if(people[num] == -1) {
                        people[num] = 1 - people[top];
                        queue.add(num);
                    }
                }
            }
        }
        return true;
    }

}
