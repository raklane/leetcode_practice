import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String args[]){

        int[] arr = new int[]{9,4,5,1,8,7,2,3,6};

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i = 0; i<arr.length; i++){
            heap.add(arr[i]);
            if(heap.size()>3)
                heap.poll();
        }

        int[] num = new int[3];
        int size = heap.size();
        for(int i = 0; i<size; i++){
            num[i] = heap.poll();
        }

        System.out.println(Arrays.toString(num));

    }
}
