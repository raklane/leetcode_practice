import java.util.ArrayList;
import java.util.List;

public class Leetcode211 {

    TrieNode root;
    public Leetcode211() {

        root = new TrieNode('\0');

    }

    public void addWord(String word) {

        TrieNode currentNode = root;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {

            char c = arr[i];
            if(currentNode.children[c-'a'] == null)
                currentNode.children[c-'a'] = new TrieNode(c);
            currentNode = currentNode.children[c-'a'];

        }
        currentNode.isWord = true;

    }

    public boolean search(String word) {

        return dfs(root, word, -1);

    }

    public boolean dfs(TrieNode node, String word, int i){

        if(i == word.length())
            return true;

        if(node == null)
            return false;

        char c = word.charAt(i+1);

        if(c != '.'){
            return dfs(node.children[c-'a'], word, i+1);
        }
        boolean result = false;
        for (int j = 0; j < 26 && !result; j++) {
            result = result || dfs(node.children[j], word, i+1);
        }
        return result;

    }

    class TrieNode{
        char c;
        TrieNode[] children;
        boolean isWord;

        TrieNode(char c){
            this.c = c;
            this.children = new TrieNode[26];
        }

    }

}
