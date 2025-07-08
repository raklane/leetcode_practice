import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode560_4 {

    public int subarraySum(int[] nums, int k) {

        if(nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        map.put(prefixSum[0], 1);
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
            if(map.containsKey(k - prefixSum[i])){
                count += map.get(k-prefixSum[i]);
            }
            int existsCount = map.getOrDefault(k-prefixSum[i], 0);
            map.put(prefixSum[i], existsCount+1);
        }
        return count;


    }

}
