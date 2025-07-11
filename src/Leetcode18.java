import java.util.*;

public class Leetcode18 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(i!=0 && nums[i] == nums[i-1])
                continue;

            for (int j = i+1; j < nums.length; j++) {

                if(j != i+1 && nums[j] == nums[j-1])
                    continue;

                int k = j+1;
                int l = nums.length-1;

                while (k<l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum > target)
                            l--;
                    else if(sum < target)
                        k++;
                    else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k<l && nums[k] == nums[k-1])
                            k++;
                        while (k<l && nums[l] == nums[l+1])
                            l--;
                    }
                }


            }

        }
        return list;

    }


}

