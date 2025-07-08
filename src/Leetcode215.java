import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : nums){
            heap.add(num);
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = heap.poll();
        }

        return ans;
    }

}
