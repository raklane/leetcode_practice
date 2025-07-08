import java.util.*;

public class Leetcode212_2 {

    public static void main(String[] args){
        System.out.println(findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath","pea","eat","rain"}));
    }

    public static List<String> findWords(char[][] board, String[] words) {

        //create a trie
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode currentNode = root;
            for(char c : word.toCharArray()){
                if(currentNode.children.containsKey(c))
                    currentNode = currentNode.children.get(c);
                else{
                    currentNode.children.put(c, new TrieNode());
                    currentNode = currentNode.children.get(c);
                }
            }
            currentNode.word = word;
        }

        Set<String> wordsFound = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, i, j, new StringBuilder(), root, wordsFound, new boolean[board.length][board[0].length]);
            }
        }
        return new ArrayList<>(wordsFound);

    }

    private static void backtracking(char[][] board, int i, int j, StringBuilder sb, TrieNode parent, Set<String> wordsFound, boolean[][] visited){

        if(i<0 || i>= board.length || j<0 || j>= board[0].length)
            return;

        if(visited[i][j])
            return;

        char c = board[i][j];
        TrieNode currentNode = parent.children.get(c);
        if(currentNode == null)
            return;

        sb.append(c);
        if(currentNode.word != null){
            wordsFound.add(sb.toString());
        }
        visited[i][j] = true;
        backtracking(board, i, j-1, sb, currentNode, wordsFound, visited);
        backtracking(board, i, j+1, sb, currentNode, wordsFound, visited);
        backtracking(board, i-1, j, sb, currentNode, wordsFound, visited);
        backtracking(board, i+1, j, sb, currentNode, wordsFound, visited);
        sb.deleteCharAt(sb.length()-1);
        visited[i][j] = false;
    }

    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

}
