public class Leetcode560_2 {

    public int subarraySum(int[] nums, int k) {

        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        int count = 0;

        for (int start = 0; start <= nums.length; start++) {
            for (int end = start+1; end <= nums.length; end++) {
                if(sum[end] - sum[start] ==  k)
                    count++;
            }
        }
        return count;

    }

}
