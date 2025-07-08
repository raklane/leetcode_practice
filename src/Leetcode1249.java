import java.util.*;

public class Leetcode1249 {

    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> closeParanthesisToRemove = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty())
                    stack.pop();
                else {
                    closeParanthesisToRemove.add(i);
                }
            }
        }

        char[] arr = s.toCharArray();
        while (!stack.isEmpty()){
            arr[stack.pop()] = ' ';
        }
        while (!closeParanthesisToRemove.isEmpty()){
            arr[closeParanthesisToRemove.removeLast()] = ' ';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != ' ')
                sb.append(arr[i]);
        }

        return sb.toString();
    }

}
