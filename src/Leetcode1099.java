import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode1099 {

    public int twoSumLessThanK(int[] nums, int k) {

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int maxSum = -1;
        while (left<right){
            if(nums[left] + nums[right] >= k)
                right--;
            else if (nums[left] + nums[right] < k) {
                maxSum = Math.max(maxSum, nums[left] + nums[right]);
                left++;
            }
        }
        return maxSum;
    }

}
