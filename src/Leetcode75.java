public class Leetcode75 {

    public void sortColors(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int currentColor = 0;

        while (left < nums.length){

            if(nums[left] == currentColor){
                left++;
                continue;
            }else{
                while (left<right && nums[right] != currentColor){
                    right--;
                }
                if(left<right){
                    nums[right] = nums[left];
                    nums[left] = currentColor;
                    left++;
                }
            }
            if(right == left){
                right = nums.length-1;
                currentColor++;
            }

        }


    }

}
