import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode212 {

    public static void main(String[] args){
        System.out.println(findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));
    }

    public static List<String> findWords(char[][] board, String[] words) {

        Set<String> wordSet = new HashSet<>(List.of(words));
        Set<String> wordsPresent = new HashSet<>();
        if(board.length == 0)
            return new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board,wordSet,i,j,wordsPresent,new StringBuilder(),new boolean[board.length][board[0].length]);
            }
        }
        return new ArrayList<>(wordsPresent);

    }

    public static void backtrack(char[][] board, Set<String> wordSet, int i, int j, Set<String> wordsPresent, StringBuilder sb, boolean[][] visited){

        if(wordSet.contains(sb.toString())){
            wordsPresent.add(sb.toString());
            wordSet.remove(sb.toString());
        }

        if(!hasWordWithPrefix(wordSet, sb.toString()))
            return;

        if(i < 0 || i>= board.length || j<0 || j>= board[0].length)
            return;

        if(visited[i][j])
            return;

        sb.append(board[i][j]);
        visited[i][j] = true;
        backtrack(board,wordSet,i,j-1,wordsPresent,sb,visited);
        backtrack(board,wordSet,i,j+1,wordsPresent,sb,visited);
        backtrack(board,wordSet,i-1,j,wordsPresent,sb,visited);
        backtrack(board,wordSet,i+1,j,wordsPresent,sb,visited);
        visited[i][j] = false;
        sb.deleteCharAt(sb.length()-1);

    }

    public static boolean hasWordWithPrefix(Set<String> wordSet, String prefix){
        for(String word : wordSet){
            if(word.startsWith(prefix))
                return true;
        }
        return false;
    }

}
