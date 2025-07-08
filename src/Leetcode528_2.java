public class Leetcode528_2 {
    
    int[] arr;

    public Leetcode528_2(int[] w) {
        int count = 0;
        for (int i = 0; i < w.length; i++) {
            count += w[i];
        }
        arr = new int[count];
        int arrIndex = 0;
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i]; j++) {
                arr[arrIndex++] = i;
            }
        }
    }

    public int pickIndex() {
        return arr[(int)(Math.random() * arr.length)];
    }

}
