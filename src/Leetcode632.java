import java.util.List;

public class Leetcode632 {

    public int[] smallestRange(List<List<Integer>> nums) {

        int smallestRange = Integer.MAX_VALUE;
        int[] smallestRangeArray = new int[2];
        boolean endLoop = false;
        int[] indexes = new int[nums.size()];

        while (!endLoop){
            int start = Integer.MAX_VALUE;
            int end = Integer.MIN_VALUE;
            int smallestStart = 0;
            for (int i = 0; i < nums.size() && !endLoop; i++) {
                List<Integer> currentList = nums.get(i);
                if(currentList.size() == indexes[i]){
                    endLoop = true;
                    break;
                }
                if(start > currentList.get(indexes[i])){
                    smallestStart = i;
                    start = currentList.get(indexes[i]);
                }
                end = Math.max(end, currentList.get(indexes[i]));
            }
            indexes[smallestStart]++;
            if(!endLoop && smallestRange > (end-start)){
                smallestRange = end-start;
                smallestRangeArray[0] = start;
                smallestRangeArray[1] = end;
            }
        }
        return smallestRangeArray;

    }

}
