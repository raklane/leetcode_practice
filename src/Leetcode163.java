import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode163 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {

        List<List<Integer>> list = new LinkedList<>();

        int start = lower;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            if(start < current){
                list.add(Arrays.asList(start,current-1));
                start = current+1;
            }
            else if(start == current){
                start++;
            }
        }

        if(start <= upper)
            list.add(Arrays.asList(start,upper));

        return list;
    }
}
