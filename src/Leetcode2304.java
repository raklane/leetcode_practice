public class Leetcode2304 {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int minCost = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            minCost = Math.min(minCost, backtrack(grid, moveCost, 0, j, dp));
        }
        return minCost;
    }


    public int backtrack(int[][] grid, int[][] moveCost, int i, int j, int[][] dp){

        if(i==grid.length-1)
            return grid[i][j];

        if(dp[i][j] != 0)
            return dp[i][j];
        
        int minCost = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) {
            minCost = Math.min(minCost, backtrack(grid, moveCost, i+1, k, dp) + moveCost[grid[i][j]][k]);
        }
        dp[i][j] = grid[i][j] + minCost;
        return dp[i][j];

    }
}
