import java.util.Arrays;

public class Leetcode238 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] dpPrefix = new int[nums.length];
        int[] dpSuffix = new int[nums.length];

        dpPrefix[0] = 1;
        dpSuffix[dpSuffix.length-1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefixProduct(i, dpPrefix, nums);
        }

        for (int i = nums.length-2; i >= 0; i--) {
            suffixProduct(i, dpSuffix, nums);
        }

        int[] productSelf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            productSelf[i] = dpPrefix[i] * dpSuffix[i];
        }
        return productSelf;

    }

    private static int suffixProduct(int i, int[] dpSuffix, int[] nums) {

        dpSuffix[i] = nums[i+1] * dpSuffix [i+1];
        return dpSuffix[i];
    }

    private static int prefixProduct(int i, int[] dpPrefix, int[] nums) {

        dpPrefix[i] = nums[i-1] * dpPrefix [i-1];
        return dpPrefix[i];

    }

}
