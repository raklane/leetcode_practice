import java.util.*;

public class Heap_Integer2dArray {

    public static void main(String[] args){

        int[][] arr = new int[][]{{1,3},{5,4},{9,4},{-1,0}};

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int[] arrElement : arr){
            heap.add(arrElement);
        }

        while (!heap.isEmpty()){
            System.out.println(Arrays.toString(heap.poll()));
        }


    }
}
