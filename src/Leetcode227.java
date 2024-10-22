import java.util.LinkedList;

public class Leetcode227 {

    public static void main(String[] args) {
        System.out.println(calculate("42"));
    }

    public static int calculate(String s) {

        s = s.replaceAll(" ", "");
        LinkedList<Character> stack = new LinkedList<>();
        int numberOfOperations = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(c != '*' && c != '/'){
                numberOfOperations++;
                stack.push(c);
            }
            else{
                int prevNum = Character.getNumericValue(stack.pop());
                int nextNum = Character.getNumericValue(s.charAt(++i));
                if(c=='*'){
                    int result = 0;
                    result = prevNum * nextNum;
                    stack.push((char)(result+'0'));
                }else{
                    double result;
                    result = prevNum/nextNum;
                    if(i+1 < s.length()-1){
                        char nextOperation = s.charAt(i+1);
                        while(nextOperation == '*' || nextOperation == '/'){

                            i=i+2;
                            nextNum = Character.getNumericValue(s.charAt(i));
                            if(nextOperation == '*')
                                result = result * nextNum;
                            else
                                result = result / nextNum;

                            nextOperation = (i+1) < s.length()-1 ? s.charAt(i+1) : ' ';
                        }
                    }
                    stack.push((char)(((int)(result))+'0'));
                }
            }

        }

        while (stack.size() != 1){

            int prevNum = Character.getNumericValue(stack.pop());
            char operation = stack.pop();
            int nextNum = Character.getNumericValue(stack.pop());
            if(operation == '+')
                stack.push((char)(prevNum+nextNum + '0'));
            else
                stack.push((char)(prevNum-nextNum));
        }

        return Character.getNumericValue(stack.pop());

    }
}
