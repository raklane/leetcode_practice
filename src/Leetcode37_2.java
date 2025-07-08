import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Leetcode37_2 {

    public static void main(String[] args){
        char[][] board = new char[9][9];
        board[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        board[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        board[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        board[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        board[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        board[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        board[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        board[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        board[8] = new char[]{'.','.','.','.','8','.','.','7','9'};

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n\n");

        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {

        Set<Character>[] rowData = new Set[9];
        Set<Character>[] colData = new Set[9];
        Set<Character>[] blockData = new Set[9];

        for (int i = 0; i < 9; i++) {
            rowData[i] = new HashSet<>();
            colData[i] = new HashSet<>();
            blockData[i] = new HashSet<>();
        }

        boolean[][] visited = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.'){
                    int blockIndex = (i/3)*2 + (i/3) + (j/3);
                    rowData[i].add(board[i][j]);
                    colData[j].add(board[i][j]);
                    blockData[blockIndex].add(board[i][j]);
                    visited[i][j] = true;
                }
            }
        }

        backtrack(board, 0, 0, rowData, colData, blockData);

    }

    public static boolean backtrack(char[][] board, int i, int j, Set<Character>[] rowData, Set<Character>[] colData, Set<Character>[] blockData){

        if(j == 9){
            j=0;
            i=i+1;
        }

        if(i == 9)
            return true;

        if(board[i][j] != '.')
            return backtrack(board, i, j+1, rowData, colData, blockData);

        if(board[i][j] == '.') {

            char k;
            for (k = '1'; k <= '9'; k++) {
                int blockIndex = (i / 3) * 2 + (i / 3) + (j / 3);
                if (rowData[i].contains(k) || colData[j].contains(k) || blockData[blockIndex].contains(k))
                    continue;
                board[i][j] = k;
                rowData[i].add(k);
                colData[i].add(k);
                blockData[i].add(k);
                if (isSudokuComplete(board))
                    break;
                int newRow = j == 8 ? i+1 : i;
                int newCol = j == 8 ? 0 : j+1;
                backtrack(board, newRow, newCol, rowData, colData, blockData);
                board[i][j] = '.';
                rowData[i].remove(k);
                colData[i].remove(k);
                blockData[i].remove(k);
            }
            if(k>'9')
                return false;
        }else{
            for (int k = 0; k < board.length; k++) {
                for (int l = 0; l < board[0].length; l++) {
                    if(board[k][l] == '.') {
                        backtrack(board, k, l, rowData, colData, blockData);
                        break;
                    }
                }
            }
        }

        return false;

    }

    public static boolean isSudokuComplete(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                    return false;
            }
        }
        return true;
    }

}


/*
0 1 2     (row/3)0*2 + (row/3) + (col/3)
1 2 3           1*2
2 3 4           2*2
 */