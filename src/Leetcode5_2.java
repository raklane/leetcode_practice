import java.util.Map;

public class Leetcode5_2 {

    public static void main(String[] args){
        System.out.println(longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {

        int n = s.length();
        if(n == 1)
            return s;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int currentLength = 1;
        int max = 0;
        String ans = "";
        while (currentLength <= n){
            for (int i = 0; i < n-currentLength; i++) {
                dp[i][i+currentLength-1] = checkPalindrome(s, i, i+currentLength, dp);
                if(dp[i][i+currentLength-1] && currentLength > max) {
                    max = currentLength;
                    ans = s.substring(i, i+currentLength);
                }
            }
            currentLength++;
        }
        return ans;

    }


    private static boolean checkPalindrome(String s, int start, int end, boolean[][] dp){
        while (start<end){
            if(dp[start][end-1])
                return true;
            if(!(s.charAt(start) == s.charAt(end-1)))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
