public class Leetcode410 {

    public int splitArray(int[] nums, int k) {

        int total = 0;
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            prefixSum[i] = total;
        }

        int largestSum = 0;

        return 0;

    }

}
