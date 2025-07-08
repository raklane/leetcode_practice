import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode666 {

    public static void main(String[] args){
        System.out.println(pathSum(new int[]{113,215,221}));
    }

    public static int pathSumResult;

    public static int pathSum(int[] nums) {

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int[] arr = new int[8];
            Arrays.fill(arr, -1);
            list.add(arr);
        }
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int level = (currentNum/100) - 1;
            int position = ((currentNum%100)/10) - 1;
            int value = (currentNum%10);
            int[] arr = list.get(level);
            arr[position] = value;
        }

        sum(list, 0, 0, 0);
        return pathSumResult;

    }

    private static void sum(List<int[]> list, int level, int position, int currentSum){

        if(level > 3)
            return;
        if(position > 7)
            return;

        int[] arr = list.get(level);
        int value = arr[position];
        if(value == -1)
            return;

        currentSum += value;
        if(level == 3){
            pathSumResult += currentSum;
            return;
        }else{
            int nextLevelChild1 = 2*position;
            int nextLevelChild2 = 2*position + 1;
            if(list.get(level+1)[nextLevelChild1] == -1 && list.get(level+1)[nextLevelChild2] == -1){
                pathSumResult += currentSum;
                return;
            }else{
                sum(list, level+1, nextLevelChild1, currentSum);
                sum(list, level+1, nextLevelChild2, currentSum);
            }
        }


    }

}
