import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class Leetcode853 {

    public static void main(String[] args){
        System.out.println(carFleet(10, new int[]{8,3,7,4,6,5}, new int[]{4,4,4,4,4,4}));
    }

    public static int carFleet(int target, int[] position, int[] speed) {

        int[][] fleet = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            fleet[i][0] = position[i];
            fleet[i][1] = speed[i];
        }

        Arrays.sort(fleet, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o2[1], o1[1]);
                else return Integer.compare(o2[0], o1[0]);
            }
        });

        int carFleetCount = 0;
        double currentTime = 0.0;
        for (int i = 0; i < fleet.length; i++) {
            double timeRequired = (double)(target-fleet[i][0])/fleet[i][1];
            if(timeRequired > currentTime){
                carFleetCount++;
                currentTime = timeRequired;
            }
        }
        return carFleetCount;
    }

}
