public class Leetcode265 {

    public static void main(String[] args){
        //System.out.println(minCostII(new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}}));
    }

    public int minCostII(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            minCost = Math.min(minCost, backtrack(costs, 0, i, dp));
        }
        return minCost;
    }

    public int backtrack(int[][] costs, int i, int color, int[][] dp){

        if(i == costs.length-1)
            return costs[i][color];

        if(dp[i][color] != 0)
            return dp[i][color];

        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < costs[0].length; j++) {
            if(j == color)
                continue;
            minCost = Math.min(minCost, backtrack(costs, i+1, j, dp));
        }

        dp[i][color] = costs[i][color] + minCost;
        return dp[i][color];

    }
}
