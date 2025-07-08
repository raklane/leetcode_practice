import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1718 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructDistancedSequence(4)));
    }

    public static int[] constructDistancedSequence(int n) {
        List<Integer> nums = new ArrayList<>();
        int[] result = new int[n*2-1];
        for (int i = n; i >= 1; i--) {
            nums.add(i);
        }

        add(nums, result, 0);
        return result;
    }

    public static void add(List<Integer> nums, int[] result, int i){

        if(i >= nums.size())
            return;
        for (int j = 0; j < result.length; j++) {
            if(result[j] == 0){
                if(nums.get(i) == 1){
                    result[j] = 1;
                    nums.remove(i);
                    return;
                }
                if(result[j+nums.get(i)] == 0){
                    result[j] = nums.get(i);
                    result[j+nums.get(i)] = nums.get(i);
                    nums.remove(i);
                    add(nums, result, i);
                }else {
                    add(nums,result,i+1);
                    break;
                }
            }
        }
        if(nums.size()>0)
            add(nums,result,0);
    }
}
