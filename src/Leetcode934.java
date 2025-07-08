import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode934 {

    public static void main(String[] args){
        System.out.println(shortestBridge(new int[][]{{0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0},{0,0,0,0,1,1,0,0},{0,0,0,1,1,0,1,0},
                {0,0,0,0,0,1,1,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}));
    }

    public static int shortestBridge(int[][] grid) {

        boolean found = false;
        int i = 0;
        int j = 0;
        for (; i < grid.length; i++) {
            j=0;
            for (; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        boolean[][] visited = new boolean[grid.length][grid.length];
        List<int[]> queue = new ArrayList<>();
        markAllVisited(grid,visited,i,j,queue);

        int minDistance = Integer.MAX_VALUE;
        for (int k = 0; k < visited.length; k++) {
            for (int l = 0; l < visited.length; l++) {
                if(visited[k][l]) {
                    minDistance = Math.min(minDistance,Math.min(Math.min(Math.min(findNearestIsland(grid, visited, k - 1, l),
                                            findNearestIsland(grid, visited, k + 1, l)),
                                    findNearestIsland(grid, visited, k, l - 1)),
                            findNearestIsland(grid, visited, k, l+1)));
                }
            }
        }
        return minDistance;
    }

    private static int findNearestIsland(int[][] grid, boolean[][] visited, int k, int l){

        if(k<0 || k>= grid.length || l<0 || l>=grid.length || visited[k][l])
            return Integer.MAX_VALUE - 100;

        if(grid[k][l] == 1)
            return 0;
        visited[k][l] = true;
        int ans =  1 + Math.min(Math.min(Math.min(findNearestIsland(grid, visited, k - 1, l),
                                findNearestIsland(grid, visited, k + 1, l)),
                        findNearestIsland(grid, visited, k, l - 1)),
                findNearestIsland(grid, visited, k, l+1));
        visited[k][l] = false;
        return ans;
    }

    private static void markAllVisited(int[][] grid, boolean[][] visited, int i, int j,List<int[]> queue){

        if(i<0 || i>= grid.length || j<0 || j>=grid.length)
            return;
        if(visited[i][j])
            return;
        if(grid[i][j] == 0)
            return;
        visited[i][j] = true;
        queue.add(new int[]{i,j});
        markAllVisited(grid,visited,i-1,j,queue);
        markAllVisited(grid,visited,i+1,j,queue);
        markAllVisited(grid,visited,i,j-1,queue);
        markAllVisited(grid,visited,i,j+1,queue);
    }



}
