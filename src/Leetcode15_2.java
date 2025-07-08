import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15_2 {

    public static void main(String[] args){

    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int[] remaining = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            remaining[i] = nums[i] * -1;
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < remaining.length; i++) {
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                if(nums[left] + nums[right] > remaining[i])
                    right--;
                else if(nums[left] + nums[right] < remaining[i])
                    left++;
                else {
                    List<Integer> currentList = new ArrayList<>();
                    currentList.add(remaining[i]*-1);
                    currentList.add(nums[left]);
                    currentList.add(nums[right]);
                    list.add(currentList);
                    left++;
                    while (left<right && nums[left] == nums[left] - 1)
                        left++;
                }

            }
        }
        return list;

    }
}
