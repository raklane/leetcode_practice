public class Leetcode528_3 {

    int[] prefixSum;
    int totalSum = 0;

    public Leetcode528_3(int[] w) {
        prefixSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }

    public int pickIndex() {

        int target = (int)(Math.random() * totalSum);
        for (int i = 0; i < prefixSum.length; i++) {
            if(prefixSum[i] > target)
                return i;
        }
        return 0;

    }

}
