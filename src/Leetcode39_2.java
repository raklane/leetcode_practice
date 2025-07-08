import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39_2 {

    public static void main(String[] args){
        List<List<Integer>> result = combinationSum(new int[]{2,3,5}, 8);
        System.out.println(result.toArray().toString());
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinationSum(result, candidates, target, 0, 0, new ArrayList<>());
        return result;

    }

    private static void generateCombinationSum(List<List<Integer>> result, int[] candidates, int target, int i, int currentSum, ArrayList<Integer> currentList) {

        if(i>= candidates.length)
            return;

        currentSum = currentSum + candidates[i];
        if(currentSum > target)
            return;
        currentList.add(candidates[i]);
        if(currentSum == target){
            result.add(new ArrayList<>(currentList));
            currentList.removeLast();
            return;
        }

        generateCombinationSum(result, candidates, target, i, currentSum, currentList);
        currentList.removeLast();
        currentSum -= candidates[i];
        generateCombinationSum(result, candidates, target, i+1, currentSum, currentList);

    }


}
