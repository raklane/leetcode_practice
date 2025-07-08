import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode140 {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "cats","dog","sand","and","cat");
        List<String> sentences = wordBreak("catsandog", list);
        System.out.println(sentences);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList<>();
        checkValidWords(s, wordDict, sentences, new ArrayList<>(), 0);
        return sentences;
    }

    public static void checkValidWords(String s, List<String> wordDict, List<String> sentences, List<String> currentWords, int i){

        if(i == s.length()){
            StringBuilder sb = new StringBuilder();
            for(String word : currentWords){
                sb.append(word);
                sb.append(" ");
            }
            sentences.add(sb.toString().trim());
            return;
        }

        int j = i+1;
        while (j <= s.length()){
            String currentWord = s.substring(i, j);
            if(wordDict.contains(currentWord)){
                currentWords.add(currentWord);
                checkValidWords(s, wordDict, sentences, currentWords, j);
                currentWords.remove(currentWord);
            }
            j++;
        }

    }
}
