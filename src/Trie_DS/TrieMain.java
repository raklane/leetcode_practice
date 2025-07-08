package Trie_DS;

public class TrieMain {

    public static void main(String[] args){

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.root);
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        System.out.println(trie.root);
        trie.search("app");

    }
}
