import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode340 {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringKDistinct("ccaabbb", 2));
    }//ecebad

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {


        int left = 0;
        int right = 0;
        int end = s.length();
        int max = 0;

        if(k>end)
            return end;
        if(k==0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        while (right < end){

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if(map.size() > k){
                while (map.size() > k){
                    int leftCount = map.get(s.charAt(left));
                    leftCount--;
                    if(leftCount == 0)
                        map.remove(s.charAt(left));
                    else
                        map.put(s.charAt(left), leftCount);
                    left++;
                }
            }
            right++;
            max = Math.max(max, right-left);

        }
        return max;
    }

}

/*

ecebad
e
ec
ece
eceb - ceb - eb
eba - ba
bad - ad

abcdef
abc
 bcd
  cde
   def

abcabdef
abc
abca
abcab
   abd
    bde
     def

 */
