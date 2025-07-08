public class Leetcode980 {

    public static void main(String[] args){
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }

    public static int uniquePathsIII(int[][] grid) {

        if(grid.length == 0)
            return 0;
        int[] startingSquare = new int[2];
        int totalNonObstacleSquares = grid.length * grid[0].length;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    startingSquare = new int[]{i,j};
                if(grid[i][j] == -1)
                    totalNonObstacleSquares--;
            }
        }
        return backtrack(grid, startingSquare[0],startingSquare[1], new boolean[grid.length][grid[0].length], 0, totalNonObstacleSquares);

    }

    public static int backtrack(int[][] grid, int i, int j, boolean[][] visited, int squaresVisited, int totalNonObstacleSquares){

        if(i <0 || i>= grid.length || j<0 || j>= grid[0].length)
            return 0;

        if(visited[i][j])
            return 0;

        if(grid[i][j] == -1)
            return 0;
        squaresVisited++;
        if(grid[i][j] == 2){
            if(squaresVisited == totalNonObstacleSquares)
                return 1;
            else
                return 0;
        }

        visited[i][j] = true;
        int left = backtrack(grid, i, j-1, visited, squaresVisited, totalNonObstacleSquares);
        int right = backtrack(grid, i, j+1, visited, squaresVisited, totalNonObstacleSquares);
        int up = backtrack(grid, i-1, j, visited, squaresVisited, totalNonObstacleSquares);
        int down = backtrack(grid, i+1, j, visited, squaresVisited, totalNonObstacleSquares);
        visited[i][j] = false;
        return left + right + up + down;

    }

}
