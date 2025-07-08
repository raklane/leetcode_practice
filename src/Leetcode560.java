import java.util.Arrays;

public class Leetcode560 {

    public static void main(String[] args){
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {

        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int sum = 0;
        int subArrayCount = 0;

        while (right < nums.length){

            sum = nums[right];
            if(sum == k){
                subArrayCount++;
                left++;
                right = left+1;
                continue;
            }
            if(sum < k){
                sum = sum + nums[right];
                right++;
            }
            else if(sum > k){
                sum = sum - nums[left];
                left++;
            }

        }
        return subArrayCount;

    }

}
