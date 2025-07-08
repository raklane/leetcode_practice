import java.util.ArrayList;
import java.util.List;

public class Leetcode46_2 {

    public static void main(String[] args){
        List<List<Integer>> list = permute(new int[]{1,2,3,4});
        for (List<Integer> subList : list){
            for(int num : subList){
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(nums[i]);
            backtrack(nums, list, tempList);
        }
        return list;

    }

    private static void backtrack(int[] nums, List<List<Integer>> list, List<Integer> tempList){

        if(tempList.size()  ==nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            for (int j = 0; j < nums.length; j++) {
                if(tempList.contains(nums[j]))
                    continue;
                tempList.add(nums[j]);
                backtrack(nums, list, tempList);
                tempList.removeLast();
            }
        }

    }
}

/*
1 2 3

1 2 3
1 3 2
2 3 1
2 1 3
3 1 2
3 2 1

 */
