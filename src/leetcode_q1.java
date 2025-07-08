public class leetcode_q1 {

    public static void main(String[] args){
        System.out.println(canMakeEqual(new int[]{-1,-1,-1,1,1,1}, 5));
    }

    public static boolean canMakeEqual(int[] nums, int k) {
        return backtrack(nums, k, 0, 0, true) || backtrack(nums, k, 0, 0, false);
    }

    private static boolean backtrack(int[] nums, int k, int i, int changes, boolean positive){

        if(changes > k)
            return false;

        if(i == nums.length-1){
            if(positive && nums[i] == 1)
                return true;
            if(!positive && nums[i] == -1)
                return true;
            return false;
        }

        if(positive){
            if(nums[i] == -1){
                nums[i] *= -1;
                nums[i+1] *= -1;
                return backtrack(nums, k, i+1, changes+1, positive);
            }else{
                return backtrack(nums, k, i+1, changes, positive);
            }
        }else{
            if(nums[i] == 1){
                nums[i] *= -1;
                nums[i+1] *= -1;
                return backtrack(nums, k, i+1, changes+1, positive);
            }else{
                return backtrack(nums, k, i+1, changes, positive);
            }
        }

    }

}

/*
1,-1,1,-1,1

 */