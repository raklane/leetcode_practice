public class Leetcode79 {
    public static void main(String[] args){
        System.out.println(exist(new char[][]{{'a','b'},{'c','d'}},"abcd"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(checkExistence(board,word,i,j,new StringBuilder(),visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkExistence(char[][] board, String word,int i, int j, StringBuilder sb, boolean[][] visited){

        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;
        if(visited[i][j])
            return false;
        sb.append(board[i][j]);
        if(sb.toString().equals(word))
            return true;
        if(!word.contains(sb.toString())){
            sb.deleteCharAt(sb.length()-1);
            return false;
        }
        visited[i][j] = true;
        boolean left = checkExistence(board,word,i,j-1,sb,visited);
        boolean right = checkExistence(board,word,i,j+1,sb,visited);
        boolean up = checkExistence(board,word,i-1,j,sb,visited);
        boolean down = checkExistence(board,word,i+1,j,sb,visited);
        visited[i][j] = false;
        sb.deleteCharAt(sb.length()-1);
        return left || right || up || down;

    }
}
