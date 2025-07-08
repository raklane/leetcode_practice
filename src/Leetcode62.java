public class Leetcode62 {

    public static void main(String[] args){

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return backtrack(0,0,m,n,dp);
    }

    public int backtrack(int i, int j, int m, int n, int[][] dp){

        if(i<0 || i >=m || j<0 || j>= n)
            return 0;

        if(dp[i][j] != 0)
            return dp[i][j];

        if(i==m-1 && j==n-1)
            return 1;

        int right = backtrack(i, j+1, m, n, dp);
        int down = backtrack(i+1, j, m, n, dp);

        dp[i][j] = right + down;

        return dp[i][j];

    }
}
