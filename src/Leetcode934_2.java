import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode934_2 {

    public static void main(String[] args){
        System.out.println(shortestBridge(new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}}));
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
        Queue<int[]> queue = new LinkedList<>();
        markAllVisited(grid,visited,i,j,queue);

        int currentDistance = 0;

        while (!queue.isEmpty()){

            List<int[]> currentCoordinates = new ArrayList<>();
            while(!queue.isEmpty()){
                currentCoordinates.add(queue.poll());
            }

            for(int[] coordinates : currentCoordinates){

                int x = coordinates[0];
                int y = coordinates[1];

                if(grid[x][y] == 1){
                    return currentDistance-1;
                }
                visited[x][y]=true;

                if(x>0 && !visited[x-1][y]){
                    queue.offer(new int[]{x-1,y});
                    visited[x-1][y] = true;
                }
                if(x<= grid.length-2 && !visited[x+1][y]){
                    queue.offer(new int[]{x+1,y});
                    visited[x+1][y] = true;
                }
                if(y>0 && !visited[x][y-1]){
                    queue.offer(new int[]{x,y-1});
                    visited[x][y-1] = true;
                }
                if(y<=grid.length-2 && !visited[x][y+1]){
                    queue.offer(new int[]{x,y+1});
                    visited[x][y+1] = true;
                }

            }
            currentDistance++;


        }
        return currentDistance;
    }

    private static void markAllVisited(int[][] grid, boolean[][] visited, int i, int j,Queue<int[]> queue){

        if(i<0 || i>= grid.length || j<0 || j>=grid.length)
            return;
        if(visited[i][j])
            return;
        if(grid[i][j] == 0)
            return;
        visited[i][j] = true;
        grid[i][j]=2;
        queue.offer(new int[]{i,j});
        markAllVisited(grid,visited,i-1,j,queue);
        markAllVisited(grid,visited,i+1,j,queue);
        markAllVisited(grid,visited,i,j-1,queue);
        markAllVisited(grid,visited,i,j+1,queue);
    }



}
