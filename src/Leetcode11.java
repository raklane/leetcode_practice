public class Leetcode11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {

        int start = 0;
        int end = height.length;
        int max = 0;
        int current = 0;
        int maxHeight = 0;
        while(start<end-1){

            for(int i=end-1;i>start;i--){

                if(maxHeight < height[i]){
                    current = Math.min(height[i],height[start]) * (i-start);
                    max = Math.max(max, current);
                }
                if(height[i] > height[start])
                    break;

            }

            start++;
            maxHeight = 0;

        }
        return max;

    }
}
