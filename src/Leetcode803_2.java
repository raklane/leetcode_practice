import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode803_2 {
    public static void main(String[] args){
        int[] ans = hitBricks(new int[][]{{0,1,1,1,1,1},{1,1,1,1,1,1},{0,0,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}},
                new int[][]{{1,3},{3,5},{0,3},{3,3},{1,1},{4,2},{1,0},{3,0},{4,5},{2,1},{4,4},{4,0},{2,4},{2,5},{3,4},{0,5},{0,4},{3,2},{1,5},{4,1},{2,2},{0,2}});
        System.out.println(Arrays.toString(ans));
    }

    public static int[] hitBricks(int[][] grid, int[][] hits) {


        if(grid.length==0)
            return new int[hits.length];

        boolean[][] wasZeroBefore = new boolean[grid.length][grid[0].length];
        for (int[] hit : hits){
            if(grid[hit[0]][hit[1]] == 0)
                wasZeroBefore[hit[0]][hit[1]] = true;
            else
                grid[hit[0]][hit[1]] = 0;
        }

        int[] fallenBricks = new int[hits.length];
        List<int[]> stableBricksList = new ArrayList<>();
        stableBrickCount(grid,-1,-1, stableBricksList);
        int stableBricks = stableBricksList.size();

        for (int i = hits.length-1; i >= 0; i--) {
            int[] index = hits[i];
            if(wasZeroBefore[index[0]][index[1]])
                continue;
            grid[index[0]][index[1]] = 1;
            stableBricksList = new ArrayList<>();
            if(stableBrickCount(grid,index[0],index[1], stableBricksList)){
                fallenBricks[i] = stableBricksList.size()-1 - stableBricks;
            }else

                fallenBricks[i] = stableBricksList.size() - stableBricks;
            stableBricks = stableBricksList.size();
        }

        return fallenBricks;
    }

    public static boolean stableBrickCount(int[][] grid, int x, int y, List<int[]> stableBricks){

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int l = 0; l < grid[0].length; l++) {
            findStableBricks(grid,0,l,stableBricks,visited);
        }
        boolean currentBrickStable = false;
        for(int[] stableBrick : stableBricks){
            if(Arrays.equals(stableBrick, new int[]{x,y})){
                currentBrickStable = true;
                break;
            }
        }
        if(currentBrickStable)
            return true;
        return false;
    }



    private static void findStableBricks(int[][] grid, int i, int j, List<int[]> stableBricks, boolean[][] visited){
        if(i<0 || i>= grid.length)
            return;
        if(j<0 || j>= grid[0].length)
            return;
        if(visited[i][j])
            return;
        if(grid[i][j] == 0)
            return;
        visited[i][j] = true;
        if(grid[i][j] == 1)
            stableBricks.add(new int[]{i,j});
        findStableBricks(grid,i,j-1,stableBricks,visited);
        findStableBricks(grid,i,j+1,stableBricks,visited);
        findStableBricks(grid,i-1,j,stableBricks,visited);
        findStableBricks(grid,i+1,j,stableBricks,visited);
    }


}
