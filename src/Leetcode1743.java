import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode1743 {
    public static void main(String[] args){

    }

    public int[] restoreArray(int[][] adjacentPairs) {

        int[] nums = new int[adjacentPairs.length + 1];
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int[] currentPair : adjacentPairs){
            int i = currentPair[0];
            int j = currentPair[1];
            if(map.get(i) == null){
                List<Integer> temp = new ArrayList<>();
                temp.add(j);
                map.put(i, temp);
            }
            else if(!map.get(i).contains(j))
                map.get(i).add(j);
            if(map.get(j) == null){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(j, temp);
            }
            if(!map.get(j).contains(i))
                map.get(j).add(i);
        }

        int[] boundary = new int[2];
        int i = 0;
        for(int key : map.keySet()){
            if(map.get(key).size() == 1)
                boundary[i++] = key;
        }
        nums[0] = boundary[0];
        nums[1] = boundary[1];

        for (int j = 0; j < nums.length; j++) {
            List<Integer> previousNeighbor = new ArrayList<>();
            if(j!=0)
                previousNeighbor.add(nums[j-1]);
            List<Integer> neighbors = map.get(nums[j]);
            for (int neighbor : neighbors){
                if(previousNeighbor.size() == 0 || neighbor != previousNeighbor.get(0))
                    nums[j+1] = neighbor;
            }

        }
        return nums;

    }


}
