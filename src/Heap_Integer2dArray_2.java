import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap_Integer2dArray_2 {

    public static void main(String[] args){

        int[][] arr = new int[][]{{1,3},{5,4},{9,4},{-1,0},{5,3}};

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return Integer.compare(o1[0],o2[0]);
                else
                    return Integer.compare(o1[1],o2[1]);
            }
        });


        for(int[] arrElement : arr){
            heap.add(arrElement);
        }

        while (!heap.isEmpty()){
            System.out.println(Arrays.toString(heap.poll()));
        }


    }
}
