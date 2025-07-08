import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode2762_2 {

    public static void main(String[] args){
        System.out.println(continuousSubarrays(new int[]{5,4,2,4}));
    }

    public static long continuousSubarrays(int[] nums) {

        int left = 0;
        int right = 0;
        int count = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        while (right < nums.length){

            int num = nums[right];
            minHeap.offer(new int[]{num, right});
            maxHeap.offer(new int[]{num, right});

            while (left<right && maxHeap.peek()[0] - minHeap.peek()[0] > 2){

                left++;
                while (!minHeap.isEmpty() && minHeap.peek()[1] < left)
                    minHeap.poll();
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < left)
                    maxHeap.poll();

            }

            count += right-left+1;
            right++;

        }
        return count;

    }

}
