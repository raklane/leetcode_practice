public class Leetcode1701 {

    public double averageWaitingTime(int[][] customers) {

        if(customers.length == 0)
            return 0;
        int currentTime = customers[0][0];
        int totalWaitingTime = 0;
        for(int[] customer : customers){

            int currentCustomerWaitingTime = 0;
            int arrivalTime = customer[0];
            int cookingTime = customer[1];
            if(currentTime > arrivalTime)
                currentCustomerWaitingTime = currentTime - arrivalTime;
            else
                currentTime = arrivalTime;
            currentCustomerWaitingTime += cookingTime;
            currentTime += cookingTime;

            totalWaitingTime += currentCustomerWaitingTime;

        }

        return (double)totalWaitingTime/ customers.length;

    }

}
//3,3,7,6,4,2
/*
initiate the current time
if current time is greater than arrival time then wait will be difference and cooking time
if current time is lesser than or equal to arrival time then wait will be cooking time
*/
