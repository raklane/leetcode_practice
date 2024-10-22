import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode17 {

    private static Map<Character,String> map = new HashMap<Character,String>();

    static{
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> list = new LinkedList<String>();
        int len = digits.length();




        if(len == 0)
            return list;
        String currentDigitLetters = map.get(digits.charAt(0));

        int index = 0;
        List<String> strList = null;
        if(index+1<digits.length()){
            strList = letterCombinations(digits.substring(index+1));
        }
        for (int j = 0; j < currentDigitLetters.length(); j++) {
            StringBuilder sb = new StringBuilder();
            sb.append(currentDigitLetters.charAt(j));
            if(strList == null)
                list.add(sb.toString());
            else{
                for(String str : strList){
                    list.add(sb.toString() + str);
                }
            }
        }

        return list;
    }

}
