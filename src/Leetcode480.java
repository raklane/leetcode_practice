import java.util.*;

public class Leetcode480 {


    public static void main(String[] args){
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{2147483647,2147483647}, 2)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length-k+1];

        int left = 0;
        int right = 0;
        boolean even = k%2 == 0? true : false;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        List<Double> list = new ArrayList<>();

        while (right < nums.length){

            while (list.size() < k && right < nums.length){
                queue.offer(new int[]{right, nums[right]});
                list.add((double)nums[right]);
                right++;
            }

            Collections.sort(list);
            if(even){
                //result[left] = (double)(list.get(k/2) + (list.get(k/2) -1)) / 2.0;
                  result[left] = ((double)list.get(k/2 - 1) + list.get(k/2)) / 2.0;
            }else {
                result[left] = list.get(k/2);
            }
            int[] top = queue.poll();
            list.remove((Integer) top[1]);

            left++;
        }
        return result;

    }

}
