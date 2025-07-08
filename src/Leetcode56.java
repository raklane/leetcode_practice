import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    public static void main(String[] args){

    }
    public int[][] merge(int[][] intervals) {

        if(intervals.length==0)
            return new int[][]{{}};

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int firstComparison = Integer.compare(o1[0],o2[0]);
                if(firstComparison != 0)
                    return firstComparison;
                else {
                    return Integer.compare(o1[1],o2[1]);
                }
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currentArray = intervals[i];
            int[] prevArray = list.getLast();
            if(currentArray[0]==prevArray[0]){
                if(currentArray[1]>prevArray[1]){
                    list.removeLast();
                    list.add(currentArray);
                }
                continue;
            }else{
                if(currentArray[0] <= prevArray[1]){
                    if(currentArray[1]>prevArray[1]){
                        list.removeLast();
                        list.add(new int[]{prevArray[0],currentArray[1]});
                    }
                    continue;
                }
            }
            list.add(currentArray);
        }
        return list.toArray(new int[list.size()][]);

    }
}
