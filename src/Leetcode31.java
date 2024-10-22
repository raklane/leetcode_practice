import java.util.Arrays;

public class Leetcode31 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,7,5,3,2};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {

        int i=nums.length-1;
        for (; i >0; i--) {
            int currentNum = nums[i];
            if(nums[i]>nums[i-1]){
                int num = nums[i-1];
                int j = nums.length-1;
                for (; j >=i ; j--) {
                    if(nums[j]>num)
                        break;
                }
                swap(nums,i-1,j);
                break;
            }

        }

        for (int k = i; k < (nums.length-i)/2+i; k++) {
            swap(nums,k, nums.length-(k-i+1));
        }

    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
