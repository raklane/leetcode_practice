public class Leetcode5 {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("bb"));

    }


    public static String longestPalindrome(String s) {

        int max = 0;
        String maxStr = null;

        for (int i = 0; i < s.length(); i++) {

            int start = i-1;
            int end = i+1;
            //check for one centered palindrome
            while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }
            if(max <= --end - ++start){
                max = Math.max(max, end-start);
                maxStr = s.substring(start,end+1);
            }

            //check for two centered palindrome
            start = i;
            end = i+1;
            while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }
            if(max <= --end - ++start){
                max = Math.max(max, end-start);
                maxStr = s.substring(start,end+1);
            }

        }
        return  maxStr;
    }
}