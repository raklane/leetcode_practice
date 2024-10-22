import java.util.Arrays;

public class Leetcode16 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int result = nums[0]+nums[1] + nums[nums.length-1];

        for (int i = 0; i < nums.length-2; i++) {

            int start = i+1;
            int end = nums.length-1;

            while (start<end){

                int currentSum = nums[i] + nums[start] + nums[end];
                if(currentSum>target)
                    end--;
                else if(currentSum<target)
                    start++;
                else
                    return currentSum;

                if(Math.abs(currentSum-target) < Math.abs(result-target)){
                    result = currentSum;
                }

            }




        }
        return result;
    }

}
