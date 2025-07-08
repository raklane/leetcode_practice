public class Leetcode63 {
    public static void main(String[] args){
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0)
            return 0;
        int[][] possiblePaths = new int[obstacleGrid.length][obstacleGrid[0].length];
        return backtrack(obstacleGrid, 0, 0, possiblePaths);
    }


    public static int backtrack(int[][] obstacleGrid, int i, int j, int[][] possiblePaths){

        if(i < 0 || i >= obstacleGrid.length || j <0 || j >= obstacleGrid[0].length)
            return 0;

        if(possiblePaths[i][j] != 0)
            return possiblePaths[i][j];

        if(obstacleGrid[i][j] == 1)
            return 0;

        if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1)
            return 1;

        int down = backtrack(obstacleGrid, i+1, j, possiblePaths);
        int right = backtrack(obstacleGrid, i, j+1, possiblePaths);

        possiblePaths[i][j] = down + right;
        return down + right;

    }
}
