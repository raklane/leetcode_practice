import java.util.*;

public class Leetcode127_3 {

    public static void main(String[] args){
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength("hit", "cog", wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord == endWord)
            return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> coveredWords = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int changes = 1;
        while (!queue.isEmpty()){
            changes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String top = queue.poll();
                Set<String> newWords = generateWords(top, wordSet, coveredWords);
                if(newWords.contains(endWord))
                    return changes;
                for(String newWord : newWords){
                    queue.add(newWord);
                }
            }
        }
        return 0;


    }

    private static Set<String> generateWords(String word, Set<String> wordList, Set<String> coveredWords){

        char[] chars = new char[26];
        for (int i = 0; i < 26; i++) {
            chars[i] = (char)('a' + i);
        }

        Set<String> result = new HashSet<>();

        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char c = wordArray[i];
            for (int j = 0; j < 26; j++) {
                wordArray[i] = chars[j];
                String s = new String(wordArray);
                if(!coveredWords.contains(s)){
                    if(wordList.contains(s)) {
                        result.add(s);
                        coveredWords.add(s);
                    }
                }
            }
            wordArray[i] = c;
        }
        return result;

    }

}
