import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode164 {

    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{12115,10639,2351,29639,31300,11245,16323,24899,8043,4076,17583,15872,19443,12887,5286,6836,31052,25648,17584,24599,13787,24727,12414,5098,26096,23020,25338,28472,4345,25144,27939,10716,3830,13001,7960,8003,10797,5917,22386,12403,2335,32514,23767,1868,29882,31738,30157,7950,20176,11748,13003,13852,19656,25305,7830,3328,19092,28245,18635,5806,18915,31639,24247,32269,29079,24394,18031,9395,8569,11364,28701,32496,28203,4175,20889,28943,6495,14919,16441,4568,23111,20995,7401,30298,2636,16791,1662,27367,2563,22169,1607,15711,29277,32386,27365,31922,26142,8792}));
    }

    public static int maximumGap(int[] nums) {

        int maxGap = 0;
        if(nums.length<2)
            return 0;
        if(nums.length == 2)
            return Math.abs(nums[0] - nums[1]);
        int smallest = Integer.MAX_VALUE;
        int largest = 0;
        for(int num : nums){
            smallest = Math.min(smallest,num);
            largest = Math.max(largest,num);
        }

        int numberOfBuckets = nums.length - 1;
        int bucketSize = (int)Math.ceil((double)((largest-smallest)/numberOfBuckets));
        int[] minOfBucket = new int[numberOfBuckets];
        int[] maxOfBucket = new int[numberOfBuckets];

        Arrays.fill(minOfBucket,Integer.MAX_VALUE);
        Arrays.fill(maxOfBucket, -1);

        for(int num : nums){

            if(num == smallest || num == largest)
                continue;

            int bucketIndex = (num - smallest) / bucketSize;

            minOfBucket[bucketIndex] = Math.min(minOfBucket[bucketIndex], num);
            maxOfBucket[bucketIndex] = Math.max(maxOfBucket[bucketIndex], num);

        }

        for (int i = 0; i < numberOfBuckets; i++) {

            if(minOfBucket[i] == Integer.MAX_VALUE){
                continue;
            }
            int currentGap = minOfBucket[i] -smallest;
            maxGap = Math.max(currentGap,maxGap);
            smallest = maxOfBucket[i];

        }

        return Math.max(maxGap, largest-smallest);

    }











    public static int maximumGap_old(int[] nums) {

        int maxGap = 0;
        if(nums.length<2)
            return 0;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int num : nums){
            if(num < smallest)
                smallest = num;
            if(num > largest)
                largest = num;
        }

        int[] buckets = new int[largest-smallest+1];

        for(int num : nums){
            buckets[num-smallest]++;
        }

        int currentGap = 0;
        for(int bucket : buckets){
            if(bucket == 0)
                currentGap++;
            else{
                currentGap++;
                maxGap = Math.max(maxGap,currentGap);
                currentGap=0;
            }

        }

        return maxGap;

    }

}
