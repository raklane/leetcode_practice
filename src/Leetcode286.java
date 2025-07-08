import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode286 {

    public static void main(String[] args){
        wallsAndGates(new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}});

    }

    public static void wallsAndGates(int[][] rooms) {

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0)
                    queue.add(new int[]{i,j});
            }
        }
        int currentDistance = 1;
        int[][] directions = new int[][]{
                {0,-1},
                {0, 1},
                {-1,0},
                {1, 0}
        };
        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int k = top[0];
                int l = top[1];

                for (int[] direction : directions){
                    int row = k + direction[0];
                    int col = l + direction[1];
                    if(row < 0 || col < 0 || row >= rooms.length || col >= rooms[0].length)
                        continue;
                    if(rooms[row][col] == Integer.MAX_VALUE){
                        rooms[row][col] = currentDistance;
                        queue.offer(new int[]{row,col});
                    }
                }

            }
            currentDistance++;

        }

    }



}
