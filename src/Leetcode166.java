import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode166 {


    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,6));
    }

    public static String fractionToDecimal(int numerator, int denominator) {

        double division = 1.0 * numerator / denominator;
        StringBuilder sb = new StringBuilder();
        int integerPart = (int)division;
        sb.append(integerPart);

        if(division-integerPart == 0)
            return sb.toString();

        StringBuilder fractionalPart = new StringBuilder();
        String fractionalPartString = "";
        HashMap<Integer,Integer> map = new HashMap<>();

        int firstDecimal = (int)(division*10);
        while (firstDecimal !=0 || division>0.0){

            division = (division*10) % 1.0;
            fractionalPart.append(firstDecimal);
            if(map.containsKey(firstDecimal))
                map.put(firstDecimal, map.get(firstDecimal) + 1);
            else
                map.put(firstDecimal, 1);

            Queue<Integer> longestFractionalPart = new LinkedList<>();
            fractionalPartString = fractionalPart.toString();
            for (int i = fractionalPartString.length()-1; i >= 0; i--) {
                if(longestFractionalPart.peek() != null){


                }
            }

            boolean fractionRepeating = false;
            for(int key : map.keySet()){
                if(map.get(key) == 2)
                    fractionRepeating = true;
            }
            if(fractionRepeating){
                fractionalPartString = fractionalPart.toString();
                fractionalPartString = fractionalPartString.substring(0,fractionalPartString.length()/2);
                sb.append(".(").append(fractionalPartString).append(")");
                return sb.toString();
            }

            firstDecimal = (int)(division*10);

        }

        return sb.append(".").append(fractionalPart).toString();

    }

}
