public class Leetcode1004 {

    public static void main(String[] args){
        System.out.println(longestOnes(new int[]{0,0,0,1},4));
    }

    public static int longestOnes(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int currentLargest = 0, largest = 0, flipped = 0;

        while (right < nums.length){
            if(nums[right] == 1){
                currentLargest++;
                right++;
                continue;
            }
            if(nums[right] == 0){
                if(flipped < k){
                    flipped++;
                    right++;
                    currentLargest++;
                    continue;
                }else{
                    while (nums[left] != 0){
                        left++;
                    }
                    left++;
                    largest = Math.max(largest, currentLargest);
                    right++;
                    currentLargest = right - left;

                }
            }
        }
        largest = Math.max(largest, currentLargest);
        return largest;

    }

}
