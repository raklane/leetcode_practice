import java.util.ArrayList;
import java.util.List;

public class Leetcode916_2 {

    public static List<String> wordSubsets(String[] words1, String[] words2) {

        int[] word2Max = new int[26];
        for (String word : words2){
            int[] count = count(word);
            for (int i = 0; i < 26; i++) {
                word2Max[i] = Math.max(word2Max[i], count[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : words1){
            int[] count = count(word);
            boolean found = true;
            for (int i = 0; i < 26; i++) {
                if(count[i] < word2Max[i]){
                    found = false;
                    break;
                }
            }
            if(found)
                result.add(word);
        }
        return result;

    }

    private static int[] count(String s){

        int[] count = new int[26];
        for (char c : s.toCharArray()){
            count[c-'a']++;
        }
        return count;

    }

}
