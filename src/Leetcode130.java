public class Leetcode130 {

    public static void main(String[] args) {
        System.out.println("hcdegjklmnopqrhstuvwxyzcdejkhmoprstvwycdkvhy".length());
    }

    public static void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                backtrack(board,i,j);

            }
        }

    }

    private static boolean backtrack(char[][] board, int row, int col){

        if(board[row][col] == 'X') return true;

        if(row==0 || row==board.length || col == board.length || col==0) return false;

        boolean isSurrounded = backtrack(board,row+1,col)
                && backtrack(board,row,col+1)
                && backtrack(board,row-1,col)
                && backtrack(board,row,col-1);

        if(isSurrounded){
            changeToX(board,row,col);
        }

        return false;

    }

    private static void changeToX(char[][] board, int row, int col){

        if(board[row][col] == 'X') return;
        board[row][col] = 'X';
        changeToX(board,row+1,col);
        changeToX(board,row,col+1);
        changeToX(board,row-1,col);
        changeToX(board,row,col-1);

    }

}
