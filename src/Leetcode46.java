import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode46 {

    public static void main(String[] args){
        List<List<Integer>> list = permute(new int[]{1,2,3});
        System.out.println("Rakesh");
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        generatePermutations(nums, currentList, list);

        return list;

    }

    private static void generatePermutations(int[] nums, List<Integer> currentList, List<List<Integer>> list){


        if(currentList.size()==nums.length){
            list.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            if(currentList.contains(currentNumber))
                continue;
            currentList.add(currentNumber);
            generatePermutations(nums, currentList, list);
            currentList.remove((Integer) currentNumber);
        }

    }
}
