public class Leetcode680 {

    public static void main(String[] args){
        System.out.println(validPalindrome("aba"));
    }

    public static boolean validPalindrome(String s) {
        return helper(s, 0, s.length()-1, 0);
    }

    public static boolean helper(String s, int start, int end, int removals){

        if(removals > 1)
            return false;

        if(start>=end)
            return true;

        if(s.charAt(start) == s.charAt(end))
            return helper(s, start+1, end-1, removals);

        return helper(s, start+1, end, removals+1) || helper(s, start, end-1, removals+1);

    }

}
