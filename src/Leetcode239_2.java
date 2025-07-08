import java.util.*;

public class Leetcode239_2 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7}, 7)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();
            deque.offerFirst(i);
        }
        ans[0] = deque.peekFirst();

        for (int i = k ; i<nums.length ; i++){

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();
            deque.offerFirst(i);
            ans[i-k+1] = deque.peekFirst();

        }

        return ans;

    }

}
