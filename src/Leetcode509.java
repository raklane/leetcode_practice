import java.util.HashMap;
import java.util.Map;

public class Leetcode509 {
    public int fib(int n) {

        return calculateFib(n, new HashMap<Integer,Integer>());

    }
    private int calculateFib(int n, Map<Integer,Integer> map){
        if(map.containsKey(n))
            return map.get(n);
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int fibNum = calculateFib(n-1,map) + calculateFib(n-2,map);
        map.put(n,fibNum);
        return fibNum;
    }
}
