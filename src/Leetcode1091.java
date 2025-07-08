import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode1091 {

    public static void main(String[] args){
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,1}}));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0,0});
        int stepCount = 1;
        boolean[][] visited = new boolean[grid.length][grid.length];
        int[][] directions = new int[][]{
                {0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}
        };

        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if(visited[curr[0]][curr[1]])
                    continue;
                visited[curr[0]][curr[1]] = true;
                if(curr[0] == grid.length-1 && curr[1] == grid.length-1 && grid[curr[0]][curr[1]] == 0)
                    return stepCount;
                if(grid[curr[0]][curr[1]] == 0){
                    for (int[] direction : directions){
                        int row = curr[0] + direction[0];
                        int col = curr[1] + direction[1];
                        if(row <0 || col < 0 || row >= grid.length || col >= grid.length)
                            continue;
                        if(visited[row][col])
                            continue;
                        if(grid[row][col] == 0)
                            queue.add(new int[]{curr[0] + direction[0], curr[1] + direction[1]});
                    }
                }

            }
            stepCount++;

        }
        return -1;

    }

}
