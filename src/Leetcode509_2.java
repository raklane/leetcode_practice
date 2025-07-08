import java.util.HashMap;
import java.util.Map;

public class Leetcode509_2 {

    public static void main(String[] args){
        System.out.println(fib(4));
    }

    public static int fib(int n) {

        return helper(n, new HashMap<Integer, Integer>());

    }

    private static int helper(int n, Map<Integer, Integer> map){

        if(map.containsKey(n))
            return map.get(n);
        if(n == 0) {
            map.put(0,0);
            return 0;
        }
        if(n == 1) {
            map.put(1,1);
            return 1;
        }
        map.put(n, helper(n-1, map) + helper(n-2, map));
        return map.get(n);

    }

}
