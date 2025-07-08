import java.util.HashSet;
import java.util.Set;

public class Leetcode1930 {

    public static void main(String[] args){
        System.out.println(countPalindromicSubsequence("aabca"));
    }

    public static int countPalindromicSubsequence(String s) {
        return backtrack(s, 0, new StringBuilder(), new HashSet<String>());
    }


    public static int backtrack(String s, int i, StringBuilder sb, Set<String> set){

        if(i == s.length())
            return 0;

        int count = 0;
        sb.append(s.charAt(i));
        if(sb.length() == 3){
            if(sb.charAt(0) == sb.charAt(2)) {
                if(!set.contains(sb.toString())){
                    set.add(sb.toString());
                    count++;
                }
            }

            sb.deleteCharAt(2);
            count += backtrack(s, i+1, sb, set);
        }else {
            count += backtrack(s, i+1, sb, set);
            sb.deleteCharAt(sb.length()-1);
            count += backtrack(s, i+1, sb, set);
        }
        return count;

    }
}
