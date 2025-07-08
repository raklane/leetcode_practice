public class MagicDictionary {

    TrieNode root;

    public MagicDictionary() {

        root = new TrieNode('\0');

    }

    public void buildDict(String[] dictionary) {

        for (String word : dictionary){

            TrieNode currentNode = root;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if(currentNode.children[arr[i] - 'a'] == null)
                    currentNode.children[arr[i] - 'a'] = new TrieNode(arr[i]);
                currentNode = currentNode.children[arr[i] - 'a'];
            }
            currentNode.isWord = true;

        }

    }

    public boolean search(String searchWord) {

        TrieNode currentNode = root;
        int lettersChanged = 0;

        char[] arr = searchWord.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            TrieNode[] siblingNodes = currentNode.children;
            currentNode = currentNode.children[arr[i]-'a'];

            if(i == arr.length - 1){
                if(currentNode == null || currentNode.isWord)
                    return false;
                for (int j = 0; j < siblingNodes.length; j++) {
                    if(siblingNodes[j] != null && siblingNodes[j].isWord)
                        return true;
                }
                return false;

            }

            if(currentNode == null)
                return false;
        }
        return false;

    }

    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isWord;
        TrieNode(char c){
            this.c = c;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}