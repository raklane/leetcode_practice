import java.util.LinkedList;

public class Leetcode32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")(((((()())()()))()(()))("));
    }

    public static int longestValidParentheses(String s) {

        int maxLength = 0;
        int currentLength = 0;
        int openBracket = 0;
        boolean openReverse = false;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if(maxLength > (s.length()-i))
                return maxLength;

            for (int j = i; j < s.length(); j++) {

                if(s.charAt(j) == '('){
                    openBracket++;
                    if(openReverse && openBracket==0){
                        openReverse = false;
                        start = j;
                    }
                }
                else{
                    openBracket--;
                    openReverse = openBracket <= 0;
                    if(openBracket == 0){
                        currentLength = j-i-start+1;
                        maxLength = Math.max(currentLength-start,maxLength);
                    }
                }

            }
            openBracket=0;
            start = 0;

        }
        return maxLength;
    }
}
