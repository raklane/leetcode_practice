import java.util.ArrayList;
import java.util.List;

public class Leetcode46_3 {

    public static void main(String[] args){
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new ArrayList<>());
        return list;

    }

    public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> currentList){

        if(currentList.size() == nums.length) {
            list.add(new ArrayList<>(currentList));
            return;
        }

        for(int num : nums){
            if(!currentList.contains(num)){
                currentList.add(num);
                dfs(nums, list, currentList);
                currentList.removeLast();
            }
        }

    }

}
