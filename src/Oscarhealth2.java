
//https://leetcode.com/discuss/interview-question/376034/Oscar-Health-or-OA-2019

public class Oscarhealth2 {

    public static void main(String[] args) {

        System.out.println(largestPixel(new int[][]{{1,1,1,1,1},{1,1,1,0,0},{1,1,1,0,0},{1,1,1,0,0},{1,1,1,1,1}},0,0));
    }

    public static int largestPixel(int[][] arr, int row, int col){

        if(row==arr.length || col == arr.length)
            return 0;
        if(arr[row][col] == 0)
            return 0;

        int i = row;
        int j = col;


        int currentSize = 1 + largestPixel(arr,row+1, col+1);

        i++;
        currentSize = Math.max(currentSize, largestPixel(arr,i,j));

        i--;
        j++;
        currentSize = Math.max(currentSize,largestPixel(arr,i,j));

        return currentSize;
    }

    public static int largestSquare(int[][] arr, int row, int col){

        if(row == arr.length || col == arr.length)
            return 0;

        if(arr[row][col] == 1){

            int rowOnes = largestSquare(arr,row+1,col);
            int colOnes = largestSquare(arr,row,col+1);

        }

    }
}
