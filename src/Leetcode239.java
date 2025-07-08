import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode239 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7}, 7)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k-1; i++) {
            heap.add(nums[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            int currentIndex = k+i-1;
            if(!heap.isEmpty() && nums[currentIndex] > heap.peek())
                heap.clear();
            heap.add(nums[currentIndex]);
            ans[i] = heap.peek();
            if(k+i-1 -heap.size() < i )
                heap.remove((Integer) nums[i]);
        }

        return ans;

    }

}
