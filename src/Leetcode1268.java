import java.util.ArrayList;
import java.util.List;

public class Leetcode1268 {

    TrieNode root = new TrieNode('\0');

    private void insert(String word){

        TrieNode currentNode = root;
        char[] cArr = word.toCharArray();
        for (int i = 0; i < cArr.length; i++) {

            char c = cArr[i];
            if(currentNode.children[c-'a'] == null)
                currentNode.children[c-'a'] = new TrieNode(c);
            currentNode = currentNode.children[c-'a'];

        }
        currentNode.isWord = word;

    }

    private void search(String searchWord, List<List<String>> list){

        char[] arr = searchWord.toCharArray();
        TrieNode currentNode = root;

        for (int i = 0; i < arr.length; i++) {

            char c = arr[i];
            if(currentNode.children[c-'a'] == null){
                list.add(new ArrayList<>());
                while (++i < arr.length)
                    list.add(new ArrayList<>());
                return;
            }
            currentNode = currentNode.children[c-'a'];
            list.add(addAdjecentNodesDfs(currentNode, new ArrayList<>()));

        }


    }

    private List<String> addAdjecentNodesDfs(TrieNode parentNode, List<String> currentList){

        if(parentNode.isWord != null)
            currentList.add(parentNode.isWord);

        if(currentList.size() == 3)
            return currentList;

        TrieNode[] children = parentNode.children;
        for (int i = 0; i < children.length; i++) {
            if(children[i] != null) {
                addAdjecentNodesDfs(children[i], currentList);
                if(currentList.size() == 3)
                    return currentList;
            }
        }
        return currentList;

    }



    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        for(String product : products)
            insert(product);

        List<List<String>> list = new ArrayList<>();
        search(searchWord, list);
        return list;

    }


    class TrieNode{
        char c;
        TrieNode[] children;
        String isWord;
        TrieNode(char c){
            this.c = c;
            this.children = new TrieNode[26];
        }
    }

}
