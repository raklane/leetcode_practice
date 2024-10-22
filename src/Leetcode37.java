import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Leetcode37 {

    private static HashSet<Character> possibleNumbers = new HashSet<>(9);
    static{
        possibleNumbers.add('1');
        possibleNumbers.add('2');
        possibleNumbers.add('3');
        possibleNumbers.add('4');
        possibleNumbers.add('5');
        possibleNumbers.add('6');
        possibleNumbers.add('7');
        possibleNumbers.add('8');
        possibleNumbers.add('9');
    }


    public static void main(String[] args) {

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

        solveIterativeSudoku(board);

    }

    public static boolean solveIterativeSudoku(char[][] board){

        HashSet<Character> row = new HashSet<>(9);
        HashSet<Character> col = new HashSet<>(9);
        HashSet<Character> box = new HashSet<>(9);

        int i = 0;
        int j = 0;
        for (i=0; i < 9; i++) {
            char c = '-';
            for (j=0; j < 9; j++) {

                c = board[i][j];
                if(c=='.')
                    break;
            }
            if(c=='.')
                break;
        }
        if(i==9 && j==9)
            return true;

        for (int k = 0; k < 9; k++) {
            if(board[i][k]!='.')
                row.add(board[i][k]);
            if(board[k][j]!='.')
                col.add(board[k][j]);
        }
        int boxRowStart = (i/3)*3;
        int boxColStart = (j/3)*3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                char c1 = board[boxRowStart+k][boxColStart+l];
                if(c1 != '.')
                    box.add(c1);
            }

        }

        HashSet<Character> hashSet = new HashSet<>(possibleNumbers);
        Iterator<Character> iterator = row.iterator();
        while (iterator.hasNext())
            hashSet.remove(iterator.next());
        iterator = col.iterator();
        while (iterator.hasNext())
            hashSet.remove(iterator.next());
        iterator = box.iterator();
        while (iterator.hasNext())
            hashSet.remove(iterator.next());

        if(hashSet.isEmpty())
            return false;

        iterator = hashSet.iterator();
        while (iterator.hasNext()){
            char currentChar = iterator.next();
            board[i][j] = currentChar;
            boolean result = solveIterativeSudoku(board);
            if(!result){
                board[i][j] = '.';
                hashSet.remove(currentChar);
                iterator = hashSet.iterator();
            }
            else
                break;
        }
        return false;

    }
}
