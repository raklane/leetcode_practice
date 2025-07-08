import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcod490 {
    public static void main(String[] args) {
        System.out.println(hasPath(new int[][]{{0,0,0,0,1,0,0},{0,0,1,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,1},{0,1,0,0,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,0,0,0},{0,0,1,0,0,0,1},{0,0,0,0,1,0,0}}, new int[]{0,}, new int[]{8,6}));
    }
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length == 0)
            return false;
        return validDestination(maze,start[0], start[1], destination, new boolean[maze.length][maze[0].length]);
    }

    public static boolean validDestination(int[][] maze, int i, int j, int[] destination, boolean[][] visited){

        if(i<0 || i> maze.length || j<0 || j>= maze.length)
            return false;

        if(visited[i][j])
            return false;
        visited[i][j] = true;

        List<int[]> newIndices = new ArrayList<>();
        newIndices.add(roll(1,maze,i,j));
        newIndices.add(roll(2,maze,i,j));
        newIndices.add(roll(3,maze,i,j));
        newIndices.add(roll(4,maze,i,j));
        boolean result = false;
        for (int[] index : newIndices){
            if(Arrays.equals(destination,index))
                return true;
            if(visited[index[0]][index[1]])
                continue;
            boolean left = validDestination(maze,index[0],index[1],destination,visited);
            boolean right = validDestination(maze,index[0],index[1],destination,visited);
            boolean up = validDestination(maze,index[0],index[1],destination,visited);
            boolean down = validDestination(maze,index[0],index[1],destination,visited);
            result = left || right || up || down;
        }
        return result;

    }

    public static int[] roll(int direction, int[][] maze, int i, int j){
        switch (direction){
            case 1:
                while (j>=0 && maze[i][j] != 1)
                    j--;
                return new int[]{i,j+1};
            case 2:
                while (j< maze.length && maze[i][j] != 1)
                    j++;
                return new int[]{i,j-1};
            case 3:
                while (i>=0 && maze[i][j] != 1)
                    i--;
                return new int[]{i+1,j};
            case 4:
                while (i< maze.length && maze[i][j] != 1)
                    i++;
                return new int[]{i-1,j};
            default:
                return new int[]{i,j};
        }
    }

}
