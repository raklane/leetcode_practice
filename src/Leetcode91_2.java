import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode91_2 {

    static Map<Integer,Integer> memo = new HashMap<>();
    public static void main(String[] args){
        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
    }
    public static int numDecodings(String s) {
        return recursiveWithMemo(0,s);
    }

    public static int recursiveWithMemo(int index, String str){

        if(memo.containsKey(index))
            return memo.get(index);

        if(index == str.length())
            return 1;

        if(str.charAt(index)=='0')
            return 0;

        if(index == str.length()-1)
            return 1;

        int ans = recursiveWithMemo(index+1, str);
        if(Integer.parseInt(str.substring(index,index+2))<=26){
            ans += recursiveWithMemo(index+2, str);
        }

        memo.put(index,ans);
        return ans;

    }
}
//56789 %100 89 /10 8     %10 9  /1 9
