import java.util.Arrays;

public class Leetcode994 {

    public int orangesRotting(int[][] grid) {

        int minMinutes = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                int minSteps = checkMinSteps(grid,i,j, new boolean[grid.length][grid[0].length]);
                if(minSteps == Integer.MIN_VALUE) return -1;
                minMinutes = minMinutes == -1 ? minSteps : Math.max(minMinutes,minSteps);

            }
        }
        return  minMinutes;

    }

    private int checkMinSteps(int[][] grid, int i, int j, boolean[][] visited) {

        if(i<0 || i>grid.length-1 || j<0 || j> grid[0].length-1) return Integer.MAX_VALUE;

        if(grid[i][j] == 2) return 0;
        if(grid[i][j] == 0) return Integer.MIN_VALUE;

        visited[i][j] = true;
        int left = Integer.MIN_VALUE, right= Integer.MIN_VALUE, up = Integer.MIN_VALUE, down = Integer.MIN_VALUE;
        if(i!=0 && !visited[i-1][j]) up = checkMinSteps(grid,i-1,j,visited);
        if(i != grid.length-1 && !visited[i+1][j]) down = checkMinSteps(grid, i+1, j, visited);
        if(j!=0 && !visited[i][j-1]) left = checkMinSteps(grid, i, j-1, visited);
        if(j!=grid[0].length-1 && !visited[i][j+1]) right = checkMinSteps(grid, i, j+1, visited);

        int result = Math.max(Math.max(Math.max(left,right),up),down);
        if(result == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return 1+result;

    }

}
