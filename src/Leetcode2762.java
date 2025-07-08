import java.util.Map;

public class Leetcode2762 {

    public static void main(String[] args){
        System.out.println(continuousSubarrays(new int[]{5,4,2,4}));
    }

    public static long continuousSubarrays(int[] nums) {

        int n = nums.length;
        int currentLen = 1;
        int startIndex = 0;
        long count = 0;

        while (currentLen <= n){

            while (startIndex <= n-currentLen){
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < currentLen; i++) {
                    min = Math.min(min, nums[i + startIndex]);
                    max = Math.max(max, nums[i + startIndex]);
                }
                if(Math.abs(min-max) <= 2)
                    count++;
                startIndex++;
            }
            currentLen++;
            startIndex=0;

        }
        return count;

    }

}
