package Trie_DS;

public class Trie {

    public TrieNode root;

    public Trie(){
        root = new TrieNode('\0');
    }

    public void insert(String word){
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(currentNode.children[c-'a'] == null){
                currentNode.children[c-'a'] = new TrieNode(c);
            }
            currentNode = currentNode.children[c-'a'];
        }
        currentNode.isWord = true;
    }

    public TrieNode getNode(String word){
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(currentNode.children[c-'a'] == null)
                return null;
            currentNode = currentNode.children[c-'a'];
        }
        return currentNode;
    }

    public boolean search(String word){
        TrieNode trieNode = getNode(word);
        return trieNode != null && trieNode.isWord;
    }

    public boolean startsWith(String prefix){
        return getNode(prefix) != null;
    }


    class TrieNode{
        public char c;
        public boolean isWord;
        public TrieNode[] children;

        public TrieNode(char c){
            this.c = c;
            isWord = false;
            children = new TrieNode[26];
        }

        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            str.append("Character : " + c + "\t" + "Children: ");
            for (int i = 0; i < this.children.length; i++) {
                TrieNode child = this.children[i];
                if(child != null){
                    str.append(child.toString());
                }
                str.append("\t");
            }
            return str.toString();
        }
    }
}
