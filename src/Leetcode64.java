public class Leetcode64 {

    public static void main(String[] args){

    }
    public int minPathSum(int[][] grid) {
        int impossibleSum = 200*200*200 + 1;
        int[][] dp = new int[grid.length][grid[0].length];
        return backtrack(grid, 0, 0, dp, impossibleSum);
    }

    public int backtrack(int[][] grid, int i, int j, int[][] dp, int impossibleSum){

        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length)
            return impossibleSum;

        if(dp[i][j] != 0)
            return dp[i][j];

        if(i == grid.length-1 && j == grid[0].length-1)
            return grid[i][j];

        int right = backtrack(grid, i, j+1, dp, impossibleSum);
        int down = backtrack(grid, i+1, j, dp, impossibleSum);
        dp[i][j] = grid[i][j] + Math.min(right, down);
        return dp[i][j];

    }
}
