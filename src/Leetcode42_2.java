import java.util.Arrays;

public class Leetcode42_2 {

    public static void main(String[] args){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {

        if(height.length == 0)
            return 0;

        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];
        maxLeftHeight[0] = height[0];
        maxRightHeight[height.length-1] = height[height.length-1];

        int rainWater = 0;

        for (int i = 1; i < height.length; i++) {
            int left_max = Math.max(height[i], maxLeftHeight[i-1]);
            maxLeftHeight[i] = left_max;
        }
        for (int i = height.length-2; i >= 0; i--) {
            int right_max = Math.max(height[i], maxRightHeight[i+1]);
            maxRightHeight[i] = right_max;
        }
        for (int i = 0; i < height.length - 1; i++) {
            rainWater += Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
        }
        return rainWater;

    }

}
