import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode127 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");

        System.out.println(ladderLength("qa","sq",list));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> coveredWords = new ArrayList<>();
        coveredWords.add(beginWord);
        List<String> wordSequence = ladderLengthSequence(new ArrayList<>(), coveredWords, beginWord, endWord, wordList);
        return wordSequence.size();
    }

    private static List<String> ladderLengthSequence(List<String> wordSequence, List<String> coveredWords, String currentWord, String endWord, List<String> wordList) {
        if(currentWord.equals(endWord)){
            if(wordSequence.isEmpty() || wordSequence.size()>coveredWords.size()){
                wordSequence.clear();
                wordSequence.addAll(coveredWords);
            }
            return wordSequence;
        }
        for(String word : wordList){
            if(coveredWords.contains(word))
                continue;
            if(numberOfDifferentCharacters(currentWord, word) == 1){
                coveredWords.add(word);
                wordSequence = ladderLengthSequence(wordSequence,coveredWords,word,endWord,wordList);
                coveredWords.remove(word);
            }
        }
        return wordSequence;
    }

    private static int numberOfDifferentCharacters(String word1, String word2) {
        int numberOfDifferentLetters = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i))
                numberOfDifferentLetters++;
        }
        return numberOfDifferentLetters;
    }


}