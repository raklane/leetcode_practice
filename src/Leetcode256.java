public class Leetcode256 {

    public static void main(String[] args){
        System.out.println(minCost(new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}}));
    }

    public static int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        int red = backtrack(costs, 0, 0, dp);
        int blue = backtrack(costs, 0, 1, dp);
        int green = backtrack(costs, 0, 2, dp);
        return Math.min(
                red,
                Math.min(
                        blue, green
                )
        );

    }
    //red : 0, blue : 1, green : 2
    public static int backtrack(int[][] costs, int i, int color, int[][] dp){

        if(i == costs.length-1)
            return costs[i][color];

        if(dp[i][color] != 0)
            return dp[i][color];

        int colorCost = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            if(color==j)
                continue;
            colorCost = Math.min(backtrack(costs, i+1, j, dp), colorCost);
        }

        dp[i][color] = costs[i][color] + colorCost;
        return dp[i][color];

    }
}
