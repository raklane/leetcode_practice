import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {

    public static void main(String[] args){
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        dfs(nums, 0, new ArrayList<>(), list);
        return list;

    }

    private static void dfs(int[] nums, int i, List<Integer> currentList, List<List<Integer>> list){

        if(i>= nums.length)
            return;

        currentList.add(nums[i]);
        list.add(new ArrayList<>(currentList));
        dfs(nums, i+1, currentList, list);
        int removed = currentList.removeLast();
        i++;
        while (i<nums.length && nums[i] == removed)
            i++;
        dfs(nums, i, currentList, list);

    }

}
