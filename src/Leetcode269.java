import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode269 {
    public static void main(String[] args){
        System.out.println(alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }

    public static String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        if(insertLetters(sb,words,0))
            return sb.toString();
        else
            return "";
    }

    public static boolean insertLetters(StringBuilder sb, String[] words, int index){

        if(index>=words.length)
            return true;
        if(!insertCurrentWord(sb, words,index))
            return false;
        return insertLetters(sb,words,index+1);

    }

    public static boolean insertCurrentWord(StringBuilder sb, String[] words, int index){

        if(index == 0){
            sb.append(words[index]);
            return true;
        }

        int j = 0;
        int lastFoundIndex = words[index].length();
        String word = words[index];
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if(j!=0){
                if(checkIfExistsBeforeIndex(sb, j, word.charAt(i)))
                    return false;
            }
            for (; j < sb.length(); j++) {
                if(sb.charAt(j) == word.charAt(i)) {
                    lastFoundIndex = j;
                    if(!temp.isEmpty())
                        sb.insert(j,temp.toString());
                    temp.delete(0,sb.length());
                    break;
                }
            }
            if(j==sb.length()){
                j = (lastFoundIndex == word.length() ? 0 : lastFoundIndex);
                temp.append(word.charAt(i));
            }
        }
        if(!temp.isEmpty())
            sb.append(temp.toString());
        return true;

    }

    private static boolean checkIfExistsBeforeIndex(StringBuilder sb, int j, char c) {
        for (int i = 0; i < j; i++) {
            if(sb.charAt(i) == c)
                return true;
        }
        return false;
    }
}
