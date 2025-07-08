import java.util.*;

public class Leetcode490 {

    public static void main(String[] args){
        System.out.println(hasPath(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[]{4,4}));
    }

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                boolean hasWall = getNextCoordinates(maze, x, y, visited, queue);
                if(x == destination[0] && y == destination[1]){
                    return hasWall;
                }
            }

        }
        return false;

    }

    private static boolean getNextCoordinates(int[][] maze, int x, int y, boolean[][] visited, Queue<int[]> queue) {
        int[][] directions = new int[][]{
                {-1,0},{0,1},{1,0},{0,-1}
        };
        boolean ans = false;
        for(int[] direction : directions){
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX < 0 || newY < 0 || newX >= maze.length || newY >= maze[0].length) {
                ans = true;
                continue;
            }
            if(visited[newX][newY])
                continue;
            visited[newX][newY] = true;
            if(maze[newX][newY] == 1) {
                ans = true;
                continue;
            }
            queue.offer(new int[]{newX, newY});
        }
        return ans;
    }

}
