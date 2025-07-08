import java.util.List;

public class Leetcode329 {
    public static void main(String[] args){
        System.out.println(longestIncreasingPath(new int[][]{{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}}));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0)
            return 0;
        int longestPath = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                longestPath = Math.max(longestPath, findLongestIncreasingPath(matrix,visited,i,j,-1));
            }
        }
        return longestPath;
    }

    public static int findLongestIncreasingPath(int[][] matrix, boolean[][] visited, int i, int j, int previousValue){
        if(i<0 || i>=matrix.length || j<0 || j>= matrix[0].length)
            return 0;
        if(visited[i][j])
            return 0;
        if(matrix[i][j] <= previousValue)
            return 0;
        visited[i][j] = true;
        int currentValue = matrix[i][j];
        int left = 1+ findLongestIncreasingPath(matrix,visited,i,j-1,matrix[i][j]);
        int right = 1+ findLongestIncreasingPath(matrix,visited,i,j+1,matrix[i][j]);
        int up = 1+ findLongestIncreasingPath(matrix,visited,i-1,j,matrix[i][j]);
        int down = 1+ findLongestIncreasingPath(matrix,visited,i+1,j,matrix[i][j]);
        visited[i][j]=false;
        return Math.max(Math.max(Math.max(left,right),up),down);

    }
}
