import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        dfs(nums, 0, new ArrayList<>(), list);
        return list;

    }

    private void dfs(int[] nums, int i, List<Integer> currentList, List<List<Integer>> list){

        if(i>= nums.length)
            return;

        if(currentList.contains(nums[i]))
            return;

        currentList.add(nums[i]);
        list.add(new ArrayList<>(currentList));
        dfs(nums, i+1, currentList, list);
        currentList.removeLast();
        dfs(nums, i+1, currentList, list);

    }

}
