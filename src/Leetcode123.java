public class Leetcode123 {
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int currentLine = 1; currentLine < prices.length; currentLine++) {
            maxProfit = Math.max(maxProfit, bookProfit(prices,currentLine));
        }
        return maxProfit;

    }

    private static int bookProfit(int[] prices, int currentLine){

        int profit1 = 0;
        int profit2 = 0;

        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i <= currentLine; i++) {
            if(prices[i] < minPrice)
                minPrice = prices[i];
            if(prices[i] > minPrice)
                profit1 = Math.max(profit1, prices[i]-minPrice);
        }

        minPrice = Integer.MAX_VALUE;
        for (int i = currentLine+1; i < prices.length; i++) {
            if(prices[i] < minPrice)
                minPrice = prices[i];
            if(prices[i] > minPrice)
                profit2 = Math.max(profit2, prices[i]-minPrice);
        }

        return profit1+profit2;

    }
}

/*
iterate through all prices
when the next price becomes more than current price then book the profit
continue to next element with and without booking the profit
if number of transactions =2 return the max of current profit and prev max profit
keep track of number of transactions and max profit
if number of transactions = 2 and max profit is more than prev max profit, return the profit
 */
