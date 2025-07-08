import java.util.*;

public class Leetcode853_3 {

    public int carFleet(int target, int[] position, int[] speed) {

        Set<Integer> carsReached = new HashSet<>();
        int fleetCount = 0;
        int n = position.length;

        int[][] arr = new int[n][2];
        for (int i = 0; i < position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] == o1[0])
                    return Integer.compare(o2[1],o1[1]);
                return Integer.compare(o2[0],o1[0]);
            }
        });

        double currentTime = 0.0;
        for (int i = 0; i < arr.length; i++) {
            double timeRequired = (double)(target-arr[i][0]) / arr[i][1];
            if(timeRequired > currentTime){
                fleetCount++;
                currentTime = timeRequired;
            }
        }
        return fleetCount;

    }

}
