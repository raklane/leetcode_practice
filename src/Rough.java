import java.util.*;

public class Rough {

    public static void main(String[] args){

        // Declare the two integer numbers
        int num1 = 2147483647; // Integer.MAX_VALUE
        int num2 = 2147483647; // Integer.MAX_VALUE

        // Calculate the sum, casting one operand to double to avoid overflow
        double sum = (double) num1 + num2;

        // Calculate the average
        double average = sum / 2.0; //  or sum / 2

        // Print the result
        System.out.println("The average is: " + average);




    }
}
