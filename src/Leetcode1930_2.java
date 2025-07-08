import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Leetcode1930_2 {

    public static void main(String[] args){
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    public static int countPalindromicSubsequence(String s) {

        int count = 0;
        Set<String> set = new HashSet<String>();

        int currentIndex = 0;
        while (currentIndex <= s.length()-3){
            Set<Character> distinctChars = new HashSet<>();
            distinctChars.add(s.charAt(currentIndex+1));
            char currentChar = s.charAt(currentIndex);
            for (int i = currentIndex+2; i < s.length(); i++) {
                if(s.charAt(i) == currentChar){
                    Iterator<Character> iterator = distinctChars.iterator();
                    while(iterator.hasNext()){
                        StringBuilder sb = new StringBuilder().append(currentChar).append(iterator.next()).append(currentChar);
                        if(!set.contains(sb.toString())){
                            set.add(sb.toString());
                            count++;
                        }

                    }
                }
                if(!distinctChars.contains(s.charAt(i)))
                    distinctChars.add(s.charAt(i));
            }
            currentIndex++;
        }
        return count;

    }
}
