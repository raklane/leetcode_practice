public class Leetcode80 {

    public int removeDuplicates(int[] nums) {

        int currentNum = Integer.MIN_VALUE;
        int currentNumCount = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length){

            if(nums[right] != currentNum){
                currentNum = nums[right];
                nums[left++] = nums[right];
                currentNumCount = 1;
            }else{
                if(currentNumCount < 2){
                    nums[left++] = nums[right];
                    currentNumCount++;
                }
            }
            right++;

        }
        return left;

    }

}
