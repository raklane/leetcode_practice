public class Leetcode1021 {

    public String removeOuterParentheses(String s) {

        char[] charArray = s.toCharArray();
        boolean complete =false;
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int openParantheses = 0;
        for(char c : charArray){
            if(c=='('){
                openParantheses++;
            }else {
                openParantheses--;
            }
            sb.append(c);
            if(openParantheses==0){
                ans.append(sb.subSequence(1,sb.length()-1));
                sb.delete(0,sb.length());
            }
        }
        return ans.toString();
    }

}
