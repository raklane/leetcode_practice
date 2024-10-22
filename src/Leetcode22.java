
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Leetcode22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        LinkedList<String> list = generateParenthesisAllCombinations(n);
        int openBrackets = 0;
        int len = list.size();
        for (int i = len-1; i >=0 ; i--) {

            String str = list.get(i);
            openBrackets=0;
            for(char c : str.toCharArray()){
                if(c == '(')
                    openBrackets++;
                else
                    openBrackets--;
                if(openBrackets <0){
                    list.remove(i);
                    break;
                }
            }
            if(openBrackets > 0)
                list.remove(i);

        }
        return list;

    }

    public static LinkedList<String> generateParenthesisAllCombinations(int n){


        LinkedList<String> list = new LinkedList<String>();
        if(n==0)
            return list;
        List<String> temp = generateParenthesisAllCombinations(n-1);
        if(temp.isEmpty()){
            list.add("()");
            list.add("))");
        }
        ListIterator<String> iterator = temp.listIterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            list.add("()" + str);
            list.add(")(" + str);
            list.add("((" + str);
            list.add("))" + str);
        }

        return list;

    }

}
