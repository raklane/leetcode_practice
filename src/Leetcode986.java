import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode986 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(intervalIntersection(new int[][]{{1,8},{16,20}}, new int[][]{{2,11},{12,13}})));
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int aIndex = 0;
        int bIndex = 0;

        List<int[]> list = new ArrayList<>();
        while (aIndex < firstList.length && bIndex < secondList.length){

            while (firstList[aIndex][1] < secondList[bIndex][0]
                    || secondList[bIndex][1] < firstList[aIndex][0]){
                if(firstList[aIndex][1] < secondList[bIndex][0])
                    aIndex++;
                else
                    bIndex++;

                if(aIndex == firstList.length || bIndex == secondList.length)
                    return list.toArray(new int[list.size()][2]);
            }

            int overlappingStart = Math.max(firstList[aIndex][0], secondList[bIndex][0]);
            int overlappingEnd = Math.min(firstList[aIndex][1], secondList[bIndex][1]);

            list.add(new int[]{overlappingStart, overlappingEnd});

            if(overlappingEnd == firstList[aIndex][1])
                aIndex++;
            else
                bIndex++;

        }

        return list.toArray(new int[list.size()][2]);

    }

}

/*

 */
