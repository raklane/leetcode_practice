import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode1334 {

    public static void main(String[] args){
        System.out.println(findTheCity(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        Map<Integer, PriorityQueue<int[]>> map = new HashMap<Integer, PriorityQueue<int[]>>();
        for (int i = 0; i < n; i++) {
            map.put(i, new PriorityQueue<int[]>(
                    (a,b) -> a[1] - b[1]
            ));
        }

        for(int[] edge : edges){
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
            map.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] city = new int[]{-1, Integer.MAX_VALUE};
        for (int key : map.keySet()){
            PriorityQueue<int[]> distances = map.get(key);
            int cityCount = 0;
            while (!distances.isEmpty()){
                int[] cityDistance = distances.poll();
                if(cityDistance[1] <= distanceThreshold)
                    cityCount++;
                else
                    break;
                int currentDistance = cityDistance[1];
                PriorityQueue<int[]> subDistance = map.get(cityDistance[0]);
                while (!subDistance.isEmpty()){
                    int[] top = subDistance.poll();
                    if(top[1]+currentDistance > distanceThreshold)
                        break;
                    distances.add(new int[]{top[0], top[1]+currentDistance});
                }
            }
            if(city[1] >= cityCount){
                if (city[1] == cityCount){
                    city[0] = Math.max(city[0], key);
                }else{
                    city[0] = key;
                    city[1] = cityCount;
                }
            }
        }
        return city[0];

    }

}
