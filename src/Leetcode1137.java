import java.util.HashMap;
import java.util.Map;

public class Leetcode1137 {

    public int tribonacci(int n) {
        return calculcateTribonacci(n, new HashMap<>());
    }

    public int calculcateTribonacci(int n, Map<Integer,Integer> map){
        if(n<=0)
            return 0;
        if(map.containsKey(n))
            return map.get(n);
        if(n==1 || n==2)
            return 1;
        int ans = calculcateTribonacci(n-1, map)
                + calculcateTribonacci(n-2, map)
                + calculcateTribonacci(n-3, map);
        map.put(n, ans);
        return ans;
    }

}
