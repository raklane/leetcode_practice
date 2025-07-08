import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1776_2 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{3,4},{5,4},{6,3},{9,1}})));
    }

    public static double[] getCollisionTimes(int[][] cars) {

        double[] collisionTimes = new double[cars.length];
        Arrays.fill(collisionTimes, -1.00000);

        List<double[]> speedAtTime = new ArrayList<>();
        int[] speedAfterCollision = new int[cars.length];
        for (int i = 0; i < speedAfterCollision.length; i++) {
            speedAfterCollision[i] = cars[i][1];
        }

        for (int i = cars.length-2; i >= 0; i--) {
            int[] currentCar = cars[i];
            int[] nextCar = cars[i+1];
            double currentCarPosition = currentCar[0];
            double nextCarPosition = nextCar[0];
            double timeSpent = 0.0;

            if(currentCar[1] <= nextCar[1] && currentCar[1] <= speedAfterCollision[i+1]){
                continue;
            }

            double currentCarSpeed = currentCar[1];
            double nextCarSpeed = nextCar[1];
            for (int j = speedAtTime.size()-1; j > 0; j--) {
                double[] nextSpeedChange = speedAtTime.get(j);
                while (currentCarPosition < nextCarPosition){
                    if(currentCarPosition + currentCarSpeed <= nextCarPosition + nextCarSpeed){

                    }
                }
            }

        }

        return collisionTimes;

    }


}

/*
7 9 11 13
4 7 10 13

9 10 11 12 13 14 15     1   10.5
6 9  12 15              3   10.5

12  2   14  16      15
9   4   13  17      15
relative speed = 2

5 9 12
3 7 11

9,1   10    10.5        11
6,3   9     10.5,1      11
5,4   9,3   10.5,1      11
3,4   7     9           11
 */
