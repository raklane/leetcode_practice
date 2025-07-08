import java.util.Arrays;

public class Leetcode1776 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{3,4},{5,4},{6,3},{9,1}})));
    }

    public static double[] getCollisionTimes(int[][] cars) {

        double[] collisionTimes = new double[cars.length];
        Arrays.fill(collisionTimes, -1.00000);
        int collisionedCarSpeed = Integer.MAX_VALUE;

        for (int i = cars.length-2; i >=0; i--) {

            int[] currentCar = cars[i];
            int[] nextCar = cars[i+1];

            if(currentCar[1] <= nextCar[1] && currentCar[1] <= collisionedCarSpeed) {
                collisionedCarSpeed = currentCar[1];
                continue;
            }

            int currentCarPosition = currentCar[0];
            int nextCarPosition = nextCar[0];
            int nextCarSpeed = nextCar[1];
            double collisionTime = 0.0;
            if(collisionTimes[i+1] != -1.0){
                double nextCarCollisionTime = collisionTimes[i+1];
                while (nextCarCollisionTime > 0.0 && currentCarPosition < nextCarPosition){
                    if(currentCarPosition + currentCar[1] <= nextCarPosition + nextCarSpeed){
                        currentCarPosition = currentCarPosition + currentCar[1];
                        nextCarPosition = nextCarPosition + nextCarSpeed;
                        nextCarCollisionTime--;
                        collisionTime++;
                    }else {
                        int relativeSpeed = currentCar[1] - nextCarSpeed;
                        int distanceToCover = nextCarPosition - currentCarPosition;
                        double timeRequired = ((double) distanceToCover) / relativeSpeed;
                        collisionTime += timeRequired;
                        nextCarPosition = currentCarPosition;
                        break;

                    }
                }
                nextCarSpeed = cars[i+2][1];
            }
            if(currentCarPosition < nextCarPosition){
                while (currentCarPosition < nextCarPosition){
                    if(currentCarPosition + currentCar[1] <= nextCarPosition + nextCarSpeed){
                        currentCarPosition = currentCarPosition + currentCar[1];
                        nextCarPosition = nextCarPosition + nextCarSpeed;
                        collisionTime++;
                    }else {
                        int relativeSpeed = currentCar[1] - nextCarSpeed;
                        int distanceToCover = nextCarPosition - currentCarPosition;
                        double timeRequired = ((double) distanceToCover) / relativeSpeed;
                        collisionTime += timeRequired;
                        break;

                    }
                }
            }
            collisionedCarSpeed = nextCarSpeed;
            collisionTimes[i] = collisionTime;

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
