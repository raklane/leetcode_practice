import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Leetcode15 {

    public static void main(String[] args) {
        List<List<Integer>> listOfList = threeSum(new int[]{-2,0,1,1,2});
        for (List<Integer> list : listOfList){
            for (int num : list){
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> listOfList = new LinkedList<List<Integer>>();
        HashSet<HashSet<Integer>> unique = new HashSet<HashSet<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {

            int start = i+1;
            int end = nums.length-1;
            int number = nums[i];
            while (start<end){

                int currentNum = nums[start] + nums[end] + number;
                if(currentNum == 0){
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    HashSet<Integer> set = new HashSet<>();
                    set.add(nums[i]);
                    set.add(nums[start]);
                    set.add(nums[end]);
                    if(!unique.contains(set)){
                        listOfList.add(list);
                    }
                    unique.add(set);
                    start++;
                    end--;
                }
                else if(currentNum<0)
                    start++;
                else
                    end--;

            }

        }
        return listOfList;

    }

}
