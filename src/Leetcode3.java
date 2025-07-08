import java.util.*;

public class Leetcode3 {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s){

        int left = 0;
        int right = 0;
        int end = s.length();
        int longest = 0;
        Set<Character> set = new HashSet<>();
        while (right < end){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
            }else{
                longest = Math.max(longest, right-left);
                while (s.charAt(left) != s.charAt(right)){
                    set.remove((Character) s.charAt(left++));
                }
                left++;
                right++;
            }

        }
        longest = Math.max(longest, right-left);
        return longest;
    }


}

/*


abcdefc
l    r
l     r
 l
  l
   l


aaa
1

abc
3

abcabcd
3

abbcaa
 */