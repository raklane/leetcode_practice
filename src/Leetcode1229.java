import java.util.*;

public class Leetcode1229 {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        List<Integer> list = new ArrayList<>();

        Arrays.sort(slots1, (o1, o2) -> {
            if(o1[0] == o2[0])
                return Integer.compare(o1[1],o2[1]);
            return Integer.compare(o1[0],o2[0]);
        });
        Arrays.sort(slots2, (o1, o2) -> {
            if(o1[0] == o2[0])
                return Integer.compare(o1[1],o2[1]);
            return Integer.compare(o1[0],o2[0]);
        });

        int index1 = 0;
        int index2 = 0;

        while (index1 < slots1.length && index2 < slots2.length){

            while (slots1[index1][1] < slots2[index2][0]
                        || slots2[index2][1] < slots1[index1][0]){
                if(slots1[index1][1] < slots2[index2][0])
                    index1++;
                else
                    index2++;
                if(index1 == slots1.length || index2 == slots2.length)
                    return list;
            }

            int startOverlap = Math.max(slots1[index1][0], slots2[index2][0]);
            int endOverlap = Math.min(slots1[index1][1], slots2[index2][1]);

            if (endOverlap - startOverlap >= duration) {
                list.add(startOverlap);
                list.add(startOverlap+duration);
                return list;
            }

            if(slots1[index1][1] < slots2[index2][1])
                index1++;
            else if(slots1[index1][1] > slots2[index2][1])
                index2++;
            else{
                index1++;
                index2++;
            }

        }
        return list;

    }

}
