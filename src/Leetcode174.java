public class Leetcode174 {

    public static void main(String[] args){
        System.out.println(calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int minHealth = backtrack(dungeon, 0, 0, dp)[1];
        if(minHealth >= 0)
            return 1;
        else
            return 1 - minHealth;
    }

    public static int[] backtrack(int[][] dungeon, int i, int j, int[][] dp){

        if(i >= dungeon.length || j >= dungeon[0].length)
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        if(i == dungeon.length-1 && j == dungeon[0].length-1)
            return new int[]{dungeon[i][j],dungeon[i][j]};

        if(dp[i][j] != 0)
            return new int[]{dungeon[i][j], dungeon[i][j]};

        int[] right = backtrack(dungeon, i, j+1, dp);
        int[] down = backtrack(dungeon, i+1, j, dp);

        int rightMin = Math.min(right[0],right[1]);
        int downMin = Math.min(down[0],down[1]);
        int maxNum = 0;
        if(rightMin > downMin) {
            maxNum = right[0];
            dp[i][j] = dungeon[i][j] + right[1];
        }
        else {
            maxNum = down[0];
            dp[i][j] = dungeon[i][j] + down[1];
        }

        return new int[]{maxNum, dp[i][j]};

    }
}
