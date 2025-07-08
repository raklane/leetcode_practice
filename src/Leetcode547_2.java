import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode547_2 {

    public static void main(String[] args){
        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }

    public static int findCircleNum(int[][] isConnected) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            int[] connection = isConnected[i];
            int src = i;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < connection.length; j++) {
                if(j==i)
                    continue;
                if(connection[j] == 1)
                    set.add(j);
            }
            map.put(src, set);
        }

        int provinceCount = 0;
        Set<Integer> visited = new HashSet<>();
        for(int key : map.keySet()){
            if(visited.contains(key))
                continue;
            provinceCount++;
            dfs(map, visited, key);
        }
        return provinceCount;

    }

    private static void dfs(Map<Integer, Set<Integer>> map, Set<Integer> visited, int key) {

        if(visited.contains(key))
            return;
        visited.add(key);
        Set<Integer> set = map.get(key);
        for(int des : set){
            dfs(map, visited, des);
        }

    }


}
