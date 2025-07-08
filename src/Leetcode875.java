import java.util.Arrays;
import java.util.Collections;

public class Leetcode875 {

    public static void main(String[] args) {

    }

    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);
        long totalBananas = 0;
        for (int i = 0; i < piles.length; i++) {
            totalBananas += piles[i];
        }
        int currentMinRate = (int)Math.ceil(totalBananas/h);
        int[] pilesCopy = Arrays.copyOf(piles,piles.length);
        while(currentMinRate<totalBananas && !checkIfSufficient(currentMinRate, pilesCopy, h)){

            pilesCopy = Arrays.copyOf(piles,piles.length);
            currentMinRate++;

        }
        return currentMinRate;

    }

    public boolean checkIfSufficient(int currentMinRate, int[] pilesCopy, int h){

        Arrays.sort(pilesCopy);
        int numberOfHours = 0;
        for (int i = pilesCopy.length-1; i >=0;) {

            if(pilesCopy[i] == 0) {
                if(pilesCopy[pilesCopy.length-1] != 0){
                    i = pilesCopy.length-1;
                    continue;
                }
                if(numberOfHours <= h)
                    return true;
                return false;
            }
            if(pilesCopy[i] <= currentMinRate)
                pilesCopy[i] = 0;
            else
                pilesCopy[i] = pilesCopy[i] - currentMinRate;

            if(i>0 && pilesCopy[i] < pilesCopy[i-1]){
                i--;
            }
            else if(i==0){
                if(pilesCopy[i] < pilesCopy[pilesCopy.length-1])
                    i = pilesCopy.length-1;
            }

            numberOfHours++;
        }
        if(numberOfHours <= h)
            return true;
        return false;

    }


}
