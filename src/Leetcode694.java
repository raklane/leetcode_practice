import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode694 {
    public static void main(String[] args){
        System.out.println(numDistinctIslands(new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}}));
    }
    public static int numDistinctIslands(int[][] grid) {

        if(grid.length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<List<int[]>> islands = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                List<int[]> currentIsland = new ArrayList<>();
                storeIslands(currentIsland, grid, i, j, visited);
                if(!currentIsland.isEmpty())
                    islands.add(currentIsland);
            }
        }

        int numberOfDistinctIslands = 0;
        for (int i = 0; i < islands.size(); i++) {
            if(distinctIsland(islands,i))
                numberOfDistinctIslands++;
        }
        return numberOfDistinctIslands;

    }

    public static boolean distinctIsland(List<List<int[]>> islands, int currentIndex){

        List<int[]> currentIsland = islands.get(currentIndex);
        for (int i = currentIndex+1; i < islands.size(); i++) {
            List<int[]> nextIsland = islands.get(i);
            if(currentIsland.size() != nextIsland.size())
                continue;
            int startRowDiff = nextIsland.get(0)[0] - currentIsland.get(0)[0];
            int startColDiff = nextIsland.get(0)[1] - currentIsland.get(0)[1];
            int j = 0;
            for (; j < currentIsland.size(); j++) {
                int[] currentIslandNode = currentIsland.get(j);
                int[] nextIslandNode = nextIsland.get(j);
                if(!((currentIslandNode[0] + startRowDiff == nextIslandNode[0]) && (currentIslandNode[1] + startColDiff == nextIslandNode[1])))
                    break;
            }
            if(j==currentIsland.size())
                return false;
        }
        return true;
    }

    public static void storeIslands(List<int[]> currentIsland, int[][] grid, int i, int j, boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return;
        if(visited[i][j])
            return;
        if(grid[i][j] == 0)
            return;
        visited[i][j] = true;
        currentIsland.add(new int[]{i,j});
        storeIslands(currentIsland,grid,i,j-1,visited);
        storeIslands(currentIsland,grid,i,j+1,visited);
        storeIslands(currentIsland,grid,i-1,j,visited);
        storeIslands(currentIsland,grid,i+1,j,visited);
    }
}
