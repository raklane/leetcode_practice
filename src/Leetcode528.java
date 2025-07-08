public class Leetcode528 {

    int total;
    int counter;
    int[] arr;

    public Leetcode528(int[] w) {

        for (int num : w)
            total += num;

        arr = new int[total];
        int i = 0;
        for (int j = 0; j < w.length; j++) {
            int num = w[j];
            for (int k = 0; k < num; k++) {
                arr[i++] = j;
            }
        }
        counter = 0;

    }

    public int pickIndex() {
        if(counter == arr.length)
            counter = 0;
        return arr[counter++];
    }

}
