import java.util.Arrays;

public class Leetcode1_2 {

    public int[] twoSum(int[] nums, int target) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;

        while (left < right){

            if(nums[left] + nums[right] == target){
                return new int[]{left,right};
            }
            if(nums[left] + nums[right] > target)
                right--;
            else
                left++;

        }
        return new int[2];

    }

}
