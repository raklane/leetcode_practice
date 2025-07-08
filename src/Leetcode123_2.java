public class Leetcode123_2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }

    public static int maxProfit(int[] prices) {

        int t1Cost = Integer.MAX_VALUE, t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0, t2Profit = 0;

        for (int price : prices) {

            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);

            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);

        }

        return t2Profit;

    }
}