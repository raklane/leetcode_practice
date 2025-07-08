import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39_3 {

    public static void main(String[] args){
        List<List<Integer>> list = combinationSum(new int[]{2,3,6,7},7);
        for (List<Integer> subList : list){
            for(int num : subList){
                System.out.println(num + "\t");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), 0, list);
        return list;

    }

    private static void backtrack(int[] candidates, int target, int i, List<Integer> currentList, int currentSum, List<List<Integer>> list){

        if(i>=candidates.length)
            return;

        currentSum += candidates[i];
        if(currentSum > target)
            return;

        currentList.add(candidates[i]);
        if(currentSum == target){
            list.add(new ArrayList<>(currentList));
            currentList.removeLast();
            return;
        }

        backtrack(candidates,target,i,currentList,currentSum,list);
        currentList.removeLast();
        currentSum -= candidates[i];
        backtrack(candidates,target,i+1,currentList,currentSum,list);

    }

}
