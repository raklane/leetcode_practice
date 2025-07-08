import java.util.Arrays;
import java.util.HashSet;

public class Azn_SuitableLocations {

    public static void main(String[] args) {

        int[] center = new int[]{2,0,3,-4};       //tc1: {-2,1,0}
        int acceptableDistance = 22;             //tc1: 8

        System.out.println(suitableLocationsCount(center,acceptableDistance));

    }

    private static int suitableLocationsCount(int[] center, int acceptableDistance){

        Arrays.sort(center);
        int acceptableLocations = 0;
        int leftMostLocation = center[0];
        HashSet<Integer> visitedLocations = new HashSet<>();
        return numberOfValidLocations(center, acceptableDistance,leftMostLocation,visitedLocations);

    }

    private static int numberOfValidLocations(int[] center, int acceptableDistance, int currentLocation, HashSet<Integer> visitedLocations){

        if(visitedLocations.contains(currentLocation))
            return 0;
        visitedLocations.add(currentLocation);
        int currentDistance = 0;
        for(int currentCenter : center){
            currentDistance += (Math.abs(currentLocation - currentCenter))*2;
        }
        int numberOfValidLocationsInt = 0;
        if(currentDistance > acceptableDistance) {
            if(currentLocation <= center[center.length-1] && currentLocation != Integer.MAX_VALUE)
                numberOfValidLocationsInt += numberOfValidLocations(center,acceptableDistance,currentLocation+1, visitedLocations);
            else
                return  0;
        }else{
            numberOfValidLocationsInt += 1;
            if(currentLocation != Integer.MIN_VALUE)
                numberOfValidLocationsInt += numberOfValidLocations(center,acceptableDistance,currentLocation-1, visitedLocations);
            if(currentLocation != Integer.MAX_VALUE)
                numberOfValidLocationsInt += numberOfValidLocations(center,acceptableDistance,currentLocation+1, visitedLocations);
        }

        return numberOfValidLocationsInt;

    }


}
