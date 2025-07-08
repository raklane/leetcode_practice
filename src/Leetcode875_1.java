import java.util.Arrays;

public class Leetcode875_1 {

    public static void main(String[] args) {

    }

    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int left = 1;
        int right = max;
        int lastSuccessFulHourRate = max;
        while(left<=right){

            int mid = (left+right)/2;
            int currentHour = 0;
            for (int i = piles.length-1; i >= 0 ; i--) {
                if(piles[i] == 0) break;
                currentHour = currentHour + ((piles[i]+mid-1)/mid);
            }

            if(currentHour<=h){
                right = mid - 1;
                lastSuccessFulHourRate = mid;
            }else{
                left  = mid + 1;
            }

        }
        return lastSuccessFulHourRate;

    }




}
