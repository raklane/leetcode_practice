import java.util.ArrayList;
import java.util.List;

public class Leetcode42 {

    public static void main(String[] args){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {

        int left = 0;
        int right = left+1;
        int rainWater = 0;

        int inBetweenHeights = 0;

        while (left < height.length && right < height.length){

            if(height[right] >= height[left]){
                rainWater += ((right-left-1) * height[left]) - inBetweenHeights;
                left = right;
                inBetweenHeights = 0;
            }else {
                inBetweenHeights += height[right];
            }


            right++;
            if(right == height.length){



                left++;
                right = left+1;
                inBetweenHeights = 0;
            }

        }

        return rainWater;


    }

}
