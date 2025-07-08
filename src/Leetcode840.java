import java.util.HashSet;

public class Leetcode840 {

    public static void main(String[] args) {

    }

    public static int numMagicSquaresInside(int[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count = count + checkMagicSquare(grid,i,j);
            }
        }
        return count;
    }

    private static int checkMagicSquare(int[][] grid, int row, int col){

        if(row > grid.length-3) return 0;
        if(col > grid[0].length-3) return 0;

        HashSet<Integer> set = new HashSet<>();
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int[] diagonalSum = new int[2];
        int totalSum = -1;
        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                if(grid[i][j]>9 || grid[i][j] == 0 ||set.contains(grid[i][j])) return 0;
                rowSum[i-row] += grid[i][j];
                colSum[j-col] += grid[i][j];
                set.add(grid[i][j]);
            }
            if(totalSum == -1) totalSum=rowSum[i-row];
            else if(totalSum != rowSum[i-row]) return 0;
        }
        for(int num : colSum){
            if(num != totalSum) return 0;
        }
        if(grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2] != totalSum) return 0;
        if(grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col] != totalSum) return 0;
        return 1;

    }



}
