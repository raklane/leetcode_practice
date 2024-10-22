import java.util.HashMap;
import java.util.HashSet;

public class Leetcode907 {

    public static void main(String[] args) {

        System.out.println(sumSubarrayMins(new int[]{3,1,2,4}));

    }

    public static int sumSubarrayMins(int[] arr) {

        int minSum = 0;

        return findMin(arr,new HashSet<Integer>(), Integer.MAX_VALUE);


    }

    public static int findMin(int[] arr, HashSet<Integer> indexesCovered, int currentMin){


        if(indexesCovered.size() == arr.length)
            return 0;
        int minSum = 0;
        int newSize = indexesCovered.size()+1;
        int currentIndexLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if(indexesCovered.contains(i)){
                continue;
            }else{
                currentMin = Math.min(currentMin,arr[i]);
                indexesCovered.add(i);
                minSum = currentMin + findMin(arr,indexesCovered,currentMin);
                indexesCovered.remove(i);
            }
        }

        return minSum;

    }

}
