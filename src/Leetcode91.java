import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Leetcode91 {
    public static void main(String[] args){
        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
    }
    public static int numDecodings(String s) {
        if(Character.getNumericValue(s.charAt(0))==0)
            return 0;
        List<String> list = new ArrayList<>();
        collectStrings(s, s.length()-1,list,"");
        return list.size();
    }

    public static void collectStrings(String s, int currentIndex, List<String> list, String sb){

        if(currentIndex <=0){
            if(currentIndex==0){
                int currentNum = Character.getNumericValue(s.charAt(currentIndex));
                sb = charValueOfInteger(currentNum) + sb;
            }
            if(!sb.isEmpty()){
                list.add(sb);
                return;
            }
        }
        int currentNum = Character.getNumericValue(s.charAt(currentIndex));
        if(currentNum >0){
            sb = charValueOfInteger(currentNum) + sb;
            collectStrings(s,currentIndex-1,list,sb);
        }else {
            if(currentIndex>0){
                int nextNum = Character.getNumericValue(s.charAt(currentIndex-1));
                if(nextNum>0 && nextNum<3){
                    int finalNum = nextNum*10+currentNum;
                    sb = charValueOfInteger(finalNum) + sb;
                    collectStrings(s,currentIndex-2,list,sb);
                }
            }else
                return;
        }
        if(currentNum>0 && currentIndex>0){
            int nextNum = Character.getNumericValue(s.charAt(currentIndex-1));
            if((currentNum<7 && nextNum==2)||(nextNum==1)){
                int finalNum = nextNum*10+currentNum;
                sb = charValueOfInteger(finalNum) + sb.substring(1);
                collectStrings(s,currentIndex-2,list,sb);
            }
        }

    }

    private static char charValueOfInteger(int num){
        return (char)('A' + num - 1);
    }
}
//56789 %100 89 /10 8     %10 9  /1 9
