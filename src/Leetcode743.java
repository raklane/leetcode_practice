import java.util.*;

public class Leetcode743 {

    public static void main(String[] args){
        System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    }


    public static int networkDelayTime(int[][] times, int n, int k) {

        Set<Integer> visited = new HashSet<>();

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] time : times){
            List<int[]> list = map.get(time[0]);
            if(list == null)
                list = new ArrayList<>();
            list.add(new int[]{time[1], time[2]});
            map.put(time[0], list);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a,b) -> a[1] - b[1]
        );
        queue.offer(new int[]{k,0});
        int currentDistance = 0;

        while (!queue.isEmpty()){
            int[] top = queue.poll();
            int des = top[0];
            currentDistance = top[1];
            if(visited.contains(des))
                continue;
            visited.add(des);
            List<int[]> list1 = map.get(des);
            if(list1 == null)
                continue;
            for (int[] duration : list1)
                queue.offer(new int[]{duration[0], duration[1] + currentDistance});

        }
        return visited.size() == n ? currentDistance : -1;

    }


}
