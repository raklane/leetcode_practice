import java.util.*;

public class Leetcode803 {
    public static void main(String[] args){
        int[] ans = hitBricks(new int[][]{{0,1,1,1,1,1},{1,1,1,1,1,1},{0,0,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}},
                new int[][]{{1,3},{3,5},{0,3},{3,3},{1,1},{4,2},{1,0},{3,0},{4,5},{2,1},{4,4},{4,0},{2,4},{2,5},{3,4},{0,5},{0,4},{3,2},{1,5},{4,1},{2,2},{0,2}});
        System.out.println(Arrays.toString(ans));
    }

    public static int[] hitBricks(int[][] grid, int[][] hits) {

        if(grid.length==0)
            return new int[]{};
        List<int[]> stableBricks = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            if(grid[0][i] == 1)
                findStableBricks(grid,0,i,stableBricks,visited);
        }

        int[] fallenBricks = new int[hits.length];
        for (int i = 0; i < hits.length; i++) {
            int[] hit = hits[i];
            int x = hit[0];
            int y = hit[1];
            if(!visited[x][y]){
                fallenBricks[i] = 0;
                continue;
            }

            fallenBricks[i] = removeUnstableBricks(hit,grid);

        }
        return fallenBricks;
    }

    private static int removeUnstableBricks(int[] currentIndex, int[][] grid){
        int x = currentIndex[0];
        int y = currentIndex[1];
        int removedNodes = 0;
        List<int[]> indexesToRemove = new ArrayList<>();
        if(!addBfsBricks(new int[]{x,y-1}, indexesToRemove, grid, new boolean[grid.length][grid[0].length]))
            while (!indexesToRemove.isEmpty()){
                removedNodes++;
                int[] indexToZero = indexesToRemove.getFirst();
                indexesToRemove.removeFirst();
                grid[indexToZero[0]][indexToZero[1]] = 0;
            }
        if(!addBfsBricks(new int[]{x,y+1}, indexesToRemove, grid, new boolean[grid.length][grid[0].length]))
            while (!indexesToRemove.isEmpty()){
                removedNodes++;
                int[] indexToZero = indexesToRemove.getFirst();
                indexesToRemove.removeFirst();
                grid[indexToZero[0]][indexToZero[1]] = 0;
            }
        if(!addBfsBricks(new int[]{x-1,y}, indexesToRemove, grid, new boolean[grid.length][grid[0].length]))
            while (!indexesToRemove.isEmpty()){
                removedNodes++;
                int[] indexToZero = indexesToRemove.getFirst();
                indexesToRemove.removeFirst();
                grid[indexToZero[0]][indexToZero[1]] = 0;
            }
        if(addBfsBricks(new int[]{x+1,y}, indexesToRemove, grid, new boolean[grid.length][grid[0].length]))
            while (!indexesToRemove.isEmpty()){
                removedNodes++;
                int[] indexToZero = indexesToRemove.getFirst();
                indexesToRemove.removeFirst();
                grid[indexToZero[0]][indexToZero[1]] = 0;
            }
        return removedNodes;
    }

    private static boolean addBfsBricks(int[] currentIndex, List<int[]> list, int[][] grid, boolean[][] visited) {
        int x = currentIndex[0];
        int y = currentIndex[1];
        if(x<0 || x>= grid.length || y<0 || y>= grid[0].length)
            return false;
        if(visited[x][y])
            return false;
        if(grid[x][y]==0)
            return false;
        if(x==0)
            return true;
        list.add(currentIndex);
        visited[x][y] = true;
        boolean left = addBfsBricks(new int[]{x,y-1}, list, grid, visited);
        boolean right = addBfsBricks(new int[]{x,y+1}, list, grid, visited);
        boolean up = addBfsBricks(new int[]{x-1,y}, list, grid, visited);
        boolean down = addBfsBricks(new int[]{x+1,y}, list, grid, visited);
        return left || right || up || down;
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
