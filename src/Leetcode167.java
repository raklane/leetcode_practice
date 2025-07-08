import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode167 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15,17}, 32)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i]))
                return new int[]{map.get(numbers[i]), i};
            int remaining = target - numbers[i];
            map.put(remaining,i);
        }
        return null;

    }


}
/*
l r
2,7,11,15

 */
