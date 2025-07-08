import java.util.HashMap;
import java.util.Map;

public class Leetcode1570 {

    Map<Integer, Integer> map;

    Leetcode1570(int[] nums) {

        map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                map.put(i, nums[i]);
        }

    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(Leetcode1570 vec) {

        int product = 0;
        Map<Integer, Integer> vecMap = vec.map;
        for(int key : vecMap.keySet()){
            if(this.map.containsKey(key)){
                product += (this.map.get(key) * vecMap.get(key));
            }
        }
        return product;

    }

}
