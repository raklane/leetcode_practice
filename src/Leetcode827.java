import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode827 {
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

        int totalOneNodes = 0;
        int largestIslandSize = 0;
        for(List<int[]> islands : numberOfIslands){
            totalOneNodes += islands.size();
            largestIslandSize = Math.max(largestIslandSize, islands.size());
        }

        List<List<int[]>> expandedIslands = new ArrayList<>();

        for (int k = 0; k < numberOfIslands.size(); k++) {
            List<int[]> currentIsland = numberOfIslands.get(k);
            List<int[]> expandedIslandNodes = new ArrayList<>();
            for(int[] coordinates : currentIsland){
                int i = coordinates[0];
                int j = coordinates[1];
                if(i-1 >= 0)
                    expandedIslandNodes.add(new int[]{i-1,j});
                if(i+1 < n)
                    expandedIslandNodes.add(new int[]{i+1,j});
                if(j-1 >= 0)
                    expandedIslandNodes.add(new int[]{i,j-1});
                if(j+1 < n)
                    expandedIslandNodes.add(new int[]{i,j+1});
            }
            expandedIslands.add(expandedIslandNodes);
        }

        for (int i = 0; i < expandedIslands.size(); i++) {
            boolean matched = false;
            List<int[]> currentExpandedIsland = expandedIslands.get(i);
                for (int j = i+1; j < expandedIslands.size() && j != i && !matched; j++) {
                    List<int[]> nextExpandedIsland = expandedIslands.get(j);

                    for(int[] arr1 : currentExpandedIsland){
                        for(int[] arr2 : nextExpandedIsland){
                            if(Arrays.equals(arr1,arr2)){
                                matched = true;
                                largestIslandSize = Math.max(largestIslandSize, numberOfIslands.get(i).size()+numberOfIslands.get(j).size()+1);
                                break;
                            }
                        }
                    if(matched)
                        break;;
                    }
                }
        }
        return largestIslandSize;

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
