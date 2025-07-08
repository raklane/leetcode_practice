public class Leetcode1034 {

    public static void main(String[] args){
        colorBorder(new int[][]{{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}},1,3,1);
    }

    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        colorBorderElements(grid,visited,row,col,grid[row][col],color);
        return grid;

    }

    public static boolean colorBorderElements(int[][] grid, boolean[][] visited, int row, int col, int currentColor, int color){

        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length)
            return true;
        if(visited[row][col])
            return false;
        if(grid[row][col] != currentColor)
            return true;
        visited[row][col] = true;

        boolean up = colorBorderElements(grid,visited,row-1,col,currentColor,color);
        boolean down = colorBorderElements(grid,visited,row+1,col,currentColor,color);
        boolean left = colorBorderElements(grid,visited,row,col-1,currentColor,color);
        boolean right = colorBorderElements(grid,visited,row,col+1,currentColor,color);

        if(left || right || up || down)
            grid[row][col] = color;

        return false;

    }


}
