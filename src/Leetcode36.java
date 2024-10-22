import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode36 {

    private static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static {
        map.put("1",0);
        map.put("2",0);
        map.put("3",0);
        map.put("4",0);
        map.put("5",0);
        map.put("9",0);
        map.put("6",0);
        map.put("7",0);
        map.put("8",0);
    }

    public static void main(String[] args) {

        int[][] sudoku = new int[9][9];

    }

    public static boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                String num = String.valueOf(board[i][j]);
                if(num.equals("."))
                    continue;
                map.put(num, map.get(num)+1);

            }
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue()>1)
                    return false;
                entry.setValue(1);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                String num = String.valueOf(board[i][j]);
                if(num.equals("."))
                    continue;
                map.put(num, map.get(num)+1);

            }
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue()>1)
                    return false;
                entry.setValue(1);
            }
        }

        for (int i = 0; i < 10; i=i+3) {
            for (int j = 0; j < 10; j++) {

                for (int k = 0; k < 3; k++) {

                    String num = String.valueOf(board[i][j]);
                    if(num.equals("."))
                        continue;
                    map.put(num, map.get(num)+1);

                }
                if((j+1)%3 == 0){
                    for(Map.Entry<String,Integer> entry : map.entrySet()){
                        if(entry.getValue()>1)
                            return false;
                        entry.setValue(1);
                    }
                }

            }

        }

        return true;

    }
}
