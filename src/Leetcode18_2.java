import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode18_2 {

    public static void main(String[] args){
        System.out.println(fourSum(new int[]{-3,-1,0,2,4,5}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;

        List<List<Integer>> result = new ArrayList<>();

        while (left<=right-3){

            int currentSum = nums[left] + nums[right];
            int cLeft = left+1;
            int cRight = right-1;
            while (cLeft < cRight){
                if(currentSum + nums[cLeft] + nums[cRight] == target){
                    List<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums[left],nums[right],nums[cLeft],nums[cRight]);
                    result.add(list);
                    cLeft++;
                    cRight--;
                }else {
                    if(currentSum + nums[cLeft] + nums[cRight] > target){
                        cRight--;
                    }else{
                        cLeft++;
                    }
                }
            }
            left++;
            right--;

        }
        return result;

    }

}

/*
sort

1,0,-1,0,-2,2
-2,-1,0,0,1,2

 */