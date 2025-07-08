public class Leetcode70 {

    public static void main(String[] args){
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {

        return helper(n);

    }

    private static int helper(int n){

        if(n==1)
            return 1;
        if(n==2)
            return 2;

        int oneStep = helper(n-1);
        int twoStep = helper(n-2);

        return oneStep + twoStep;

    }
}
