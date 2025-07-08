import java.util.HashSet;
import java.util.Set;

public class Leetcode277 {

    public int findCelebrity(int n) {

        int[] knownArray = new int[n];
        Set<Integer> knowsNoOne = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int countKnows = 0;
            for (int j = 0; j < n; j++) {
                if(i==j)
                    continue;
                if(knows(i, j)){
                    countKnows++;
                    knownArray[j]++;
                }
            }
            if(countKnows == 0)
                knowsNoOne.add(i);
        }
        for(int i : knowsNoOne){
            if(knownArray[i] == n-1)
                return i;
        }
        return -1;

    }

    private boolean knows(int a, int b){
        return true;
    }
}
