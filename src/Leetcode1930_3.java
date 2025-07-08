import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Leetcode1930_3 {

    public static void main(String[] args){
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    public static int countPalindromicSubsequence(String s) {

        int count = 0;
        Set<String> palindromes = new HashSet<>();
        Set<Character> uniqueLettersInS = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            uniqueLettersInS.add(s.charAt(i));
        }

        Iterator<Character> iterator = uniqueLettersInS.iterator();
        while (iterator.hasNext()){

            int currentLetter = iterator.next();
            int i = -1, j = s.length();
            for (int k = 0; k < s.length(); k++) {
                if(s.charAt(k) == currentLetter){
                    if(i == -1)
                        i = k;
                    j = k;
                }
            }
            if(i != -1 && i != j){
                Set<Character> uniqueLettersInBetween = new HashSet<>();
                for (int k = i+1; k < j; k++) {
                    uniqueLettersInBetween.add(s.charAt(k));

                }
                count += uniqueLettersInBetween.size();
            }


        }
        return count;

    }
}
