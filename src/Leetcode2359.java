import java.util.ArrayList;
import java.util.List;

public class Leetcode2359 {
    public static void main(String[] args){
        System.out.println(closestMeetingNode(new int[]{4,4,8,-1,9,8,4,4,1,1},5,6));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        boolean loopOneStops = false;
        boolean loopTwoStops = false;

        while (!loopOneStops || !loopTwoStops){
            if(secondList.contains(node1))
                return node1;
            if(!loopOneStops){
                firstList.add(node1);
                node1 = edges[node1];
                if(firstList.contains(node1) || node1 == -1)
                    loopOneStops = true;
            }
            if(firstList.contains(node2))
                return node2;
            if(node2 != -1 && !loopTwoStops){
                secondList.add(node2);
                node2 = edges[node2];
                if(secondList.contains(node2) || node2 == -1)
                    loopTwoStops = true;
            }
        }
        return -1;
    }
    
}
