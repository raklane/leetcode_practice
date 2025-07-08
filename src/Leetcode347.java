import java.util.*;

public class Leetcode347 {

    public static void main(String[] args){

    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums){
            Integer count = countMap.get(num);
            if(count == null)
                countMap.put(num, 1);
            else
                countMap.put(num, count+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1,n2) -> countMap.get(n1) - countMap.get(n2)
        );
        for(int key : countMap.keySet()){
            heap.add(key);
            if(heap.size() > k)
                heap.poll();
        }

        int[] num = new int[k];
        for (int i = 0; i < k; i++) {
            num[i] = heap.poll();
        }

        return num;

    }

}
