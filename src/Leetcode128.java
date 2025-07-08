import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode128 {

    public static void main(String[] args){
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public static int longestConsecutive(int[] nums) {

        if(nums.length == 0)
            return 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }

        int count = 1;
        int max = 0;
        int prev = queue.poll();

        while (!queue.isEmpty()){
            int num = queue.poll();
            if(prev == num)
                continue;
            if(num == prev+1)
                count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
            prev = num;
        }
        max = Math.max(max, count);
        return max;

    }

}
