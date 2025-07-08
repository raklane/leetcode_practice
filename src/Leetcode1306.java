import java.util.Arrays;

public class Leetcode1306 {
    public static void main(String[] args){
        boolean[] memo = new boolean[2];
        System.out.println(memo[0]);
    }

    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return helper(arr, start, visited);

    }

    private boolean helper(int[] arr, int start, boolean[] visited){

        if(start<0 || start>=arr.length)
            return false;

        if(visited[start])
            return false;

        if(arr[start] == 0)
            return true;

        visited[start] = true;
        int value = arr[start];
        return (helper(arr, start + arr[start], visited) || helper(arr, start - arr[start], visited));

    }

}
