import java.util.*;

public class Leetcode2589_2 {

    public static void main(String[] args){
        System.out.println(findMinimumTime(new int[][]{{14,20,5},{2,18,7},{6,14,1},{3,16,3}}));
    }
    public static int findMinimumTime(int[][] tasks) {

        Arrays.sort(tasks,(t1,t2) -> (t1[1]==t2[1]) ? t1[0]-t2[0] : t1[1]-t2[1]);
        Set<Integer> used = new HashSet<>();

        int answer = 0;

        for(int[] task : tasks){

            int usedTime = 0;
            for (int i = task[0]; i <= task[1]; i++) {
                    if(used.contains(i))
                        usedTime++;
            }
            int timeLeft = task[2]-usedTime;

            for (int i = task[1]; i >= task[0] && timeLeft>0; i--) {
                if(used.add(i)){
                    answer++;
                    timeLeft--;
                }
            }

        }
        return answer;

    }


}
