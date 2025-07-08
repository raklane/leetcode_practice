import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode827_2 {
    public static void main(String[] args){
        System.out.println(largestIsland(new int[][]{{0,0,0,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}}));
    }

    public static int largestIsland(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid.length];
        List<List<int[]>> numberOfIslands = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                List<int[]> currentIslandNode = new ArrayList<>();
                findNumberOfIslands(numberOfIslands, grid, visited, i, j, currentIslandNode);
                if(!currentIslandNode.isEmpty())
                    numberOfIslands.add(currentIslandNode);
            }
        }
        int n = grid.length;
        if(numberOfIslands.isEmpty())
            if(n>0)
                return 1;
            else
                return 0;

        else if(numberOfIslands.size() == 1){
            if(numberOfIslands.getFirst().size() == grid.length* grid.length)
                return numberOfIslands.getFirst().size();
            else
                return numberOfIslands.getFirst().size()+1;
        }

        List<List<int[]>> numberOfIslandsAfterChange = new ArrayList<>();
        int maxIslandSizeAfterChange = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                visited = new boolean[grid.length][grid.length];
                if(grid[i][j] == 0){
                    grid[i][j]=1;
                    List<int[]> currentIslandNode = new ArrayList<>();
                    findNumberOfIslands(numberOfIslandsAfterChange, grid, visited, i, j, currentIslandNode);
                    maxIslandSizeAfterChange = Math.max(maxIslandSizeAfterChange, currentIslandNode.size());
                    grid[i][j]=0;
                }

            }
        }
        return maxIslandSizeAfterChange;

    }

    private static void findNumberOfIslands(List<List<int[]>> numberOfIslands, int[][] grid, boolean[][] visited, int i, int j, List<int[]> currentIslandNode) {

        if(i<0 || i>= grid.length || j<0 ||j>= grid.length)
            return;
        if(visited[i][j])
            return;
        if(grid[i][j] == 0)
            return;
        currentIslandNode.add(new int[]{i,j});
        visited[i][j] = true;
        findNumberOfIslands(numberOfIslands,grid,visited,i-1,j,currentIslandNode);
        findNumberOfIslands(numberOfIslands,grid,visited,i+1,j,currentIslandNode);
        findNumberOfIslands(numberOfIslands,grid,visited,i,j-1,currentIslandNode);
        findNumberOfIslands(numberOfIslands,grid,visited,i,j+1,currentIslandNode);

    }


}
