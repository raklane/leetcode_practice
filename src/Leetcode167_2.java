import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode167_2 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15,17}, 32)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while (left<right){
            if(numbers[left] + numbers[right] < target)
                left++;
            else if(numbers[left] + numbers[right] > target)
                right--;
            else if(numbers[left] + numbers[right] == target)
                return new int[]{left+1, right+1};
        }
        return null;
    }

}
