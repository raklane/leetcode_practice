import java.util.Arrays;

public class Leetcode2294 {

    public static void main(String[] args){
        System.out.println(Math.pow(10,5) < Math.pow(2,31)-1);
    }

    public int partitionArray(int[] nums, int k) {

        Arrays.sort(nums);

        int count = 0;
        int min = (int)Math.pow(10,5) + 1;
        int max = -1;
        int currentIndex = 0;

        while (currentIndex < nums.length){

            min = Math.min(min, nums[currentIndex]);
            max = Math.max(max, nums[currentIndex]);
            if(max - min > k){
                count++;
                min = nums[currentIndex];
                max = nums[currentIndex];
            }
            currentIndex++;

        }

        return count+1;

    }

}
