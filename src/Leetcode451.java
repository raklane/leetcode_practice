import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode451 {
    public static void main(String[] args){

    }

    public String frequencySort(String s) {

        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray()){
            Integer count = countMap.get(c);
            if(count == null)
                countMap.put(c, 1);
            else
                countMap.put(c,count+1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>(
                (c1,c2) -> countMap.get(c2) - countMap.get(c1)
        );
        for (char c : countMap.keySet()){
            heap.add(c);
        }

        StringBuilder sb = new StringBuilder();
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            char c = heap.poll();
            for (int j = 0; j < countMap.get(c); j++) {
                sb.append(c);

            }
        }
        return sb.toString();
    }

}
