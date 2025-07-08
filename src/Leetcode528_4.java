public class Leetcode528_4 {

    int[] prefixSum;
    int totalSum = 0;

    public Leetcode528_4(int[] w) {
        prefixSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }

    public int pickIndex() {

        int target = (int)(Math.random() * totalSum);

        int start = 0;
        int end = prefixSum.length;

        while (start < end){
            int mid = start + (end-start)/2;
            if(prefixSum[mid] < target)
                start = mid+1;
            else
                end = mid;
        }
        return start;

    }

}

/*
1 3 5 9 11 13
s          e
    m
      s    e
         m
      s  e
      m
         se
 */
