public class Leetcode29 {

    public static void main(String[] args) {
        System.out.println(divide(1,1));
    }

    public static int divide(int dividend, int divisor) {

        int quotient = 0;
        int dividentSign = dividend>=0 ? 1 : -1;
        int divisorSign = divisor>=0 ? 1 : -1;

        if(divisor==Integer.MIN_VALUE){
            if(dividend == Integer.MIN_VALUE)
                return 1;
            return 0;
        }

        if(dividend==Integer.MIN_VALUE){
            dividend = dividend + Math.abs(divisor);
            quotient++;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while(dividend>=divisor){
            quotient++;
            dividend -= divisor;
        }


        return quotient*dividentSign*divisorSign;

    }
}
