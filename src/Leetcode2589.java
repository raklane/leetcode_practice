import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode2589 {

    public static void main(String[] args){
        System.out.println(findMinimumTime(new int[][]{{14,20,5},{2,18,7},{6,14,1},{3,16,3}}));
    }
    public static int findMinimumTime(int[][] tasks) {
        return helper(tasks, 0, new HashSet<>());
    }

    private static int helper(int[][] tasks, int currentTask, HashSet onHours){
        if(currentTask >= tasks.length)
            return onHours.size();
        int start = tasks[currentTask][0];
        int end = tasks[currentTask][1];
        int duration = tasks[currentTask][2];
        int numOfHours = Integer.MAX_VALUE;

        List<List<Integer>> list = new ArrayList<>();
        getCombinationOfHours(start,end,duration,list,new ArrayList<>());

        for(List<Integer> currentList : list){
            currentList.removeAll(onHours);
            for(int hourNum : currentList)
                onHours.add(hourNum);
            numOfHours = Math.min(numOfHours, helper(tasks,currentTask+1,onHours));
            onHours.removeAll(currentList);
        }
        return numOfHours;
    }

    public static void getCombinationOfHours(int start, int end, int length, List<List<Integer>> list, List<Integer> currentList){

        if(currentList.size() == length){
            list.add(new ArrayList<>(currentList));
            return;
        }

        if(currentList.size() + (end-start+1) < length)
            return;

        for (int i = start; i <= end; i++) {
            currentList.add(i);
            getCombinationOfHours(i+1,end,length,list,currentList);
            currentList.removeLast();
        }

    }
}
