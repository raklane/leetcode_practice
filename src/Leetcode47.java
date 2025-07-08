import java.util.ArrayList;
import java.util.List;

public class Leetcode47 {

    public static void main(String[] args){
        System.out.println(permuteUnique(new int[]{1,1,3}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, list, new ArrayList<>(), visited);
        return list;

    }

    private static void dfs(int[] nums, List<List<Integer>> list, List<Integer> currentList, boolean[] visited){

        if(currentList.size() == nums.length){
            list.add(new ArrayList<>(currentList));
            return;
        }

        for (int j = 0; j < nums.length; j++) {

            if(visited[j])
                continue;

            if(j>0 && nums[j] == nums[j-1] && !visited[j-1])
                continue;

            currentList.add(nums[j]);
            visited[j] = true;
            dfs(nums, list, currentList, visited);
            currentList.removeLast();
            visited[j] = false;

        }

    }

}
