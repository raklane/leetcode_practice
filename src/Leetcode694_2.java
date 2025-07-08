import java.util.*;

public class Leetcode694_2 {

    public static void main(String[] args){
        System.out.println(numDistinctIslands(new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}}));
    }

    public static int numDistinctIslands(int[][] grid) {

        if(grid.length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                StringBuilder islandIndexes = new StringBuilder();
                findIslands(grid, i, j,i, j, islandIndexes, visited);
                if(islandIndexes.length() != 0)
                    islands.add(islandIndexes.toString());
            }
        }

        return islands.size();

    }

    private static void findIslands(int[][] grid, int i, int j, int row, int col, StringBuilder islandIndexes, boolean[][] visited){

        if(i < 0 || j < 0 || i>=grid.length || j >= grid[0].length)
            return;

        if(visited[i][j])
            return;
        visited[i][j] = true;

        if(grid[i][j] == 0)
            return;

        islandIndexes.append(i - row);
        islandIndexes.append(" ");
        islandIndexes.append(j - col);
        findIslands(grid, i, j-1, row, col, islandIndexes, visited);
        findIslands(grid, i, j+1, row, col, islandIndexes, visited);
        findIslands(grid, i-1, j, row, col, islandIndexes, visited);
        findIslands(grid, i+1, j, row, col, islandIndexes, visited);

    }

}
