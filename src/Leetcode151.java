import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leetcode151 {

    public static void main(String[] args){
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        Stack<String> stack = new Stack<>();
        for(String str : arr){
            if(!str.equals(""))
                stack.push(str.trim());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();

    }

}
