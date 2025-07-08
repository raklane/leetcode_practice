import java.util.HashSet;
import java.util.Set;

public class Leetcode159 {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        int current = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            set.add(c);
            if(set.size() <= 2) {
                current++;
            }
            else {
                max = Math.max(max, current);
                char t = s.charAt(right-1);
                int temp = right-1;
                while (temp > left && (s.charAt(temp) == t || s.charAt(temp) == c)){
                    temp--;
                }
                set.remove(s.charAt(temp));
                left = temp+1;
                current = right-left+1;
            }
            right++;
        }
        return Math.max(max, current);

    }

}
