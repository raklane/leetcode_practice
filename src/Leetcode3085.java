import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode3085 {
    public static void main(String[] args){
        System.out.println(minimumDeletions("qbbbbvbbbvqb", 0));
    }

    public static int minimumDeletions(String word, int k) {

        int[] count = new int[26];
        for(char c : word.toCharArray()){
            count[c-'a']++;
        }
        Arrays.sort(count);
        int left = 0;
        int right = 25;
        while (count[left] == 0) {
            left++;
        }
        int deleted = 0;
        while (right>left && count[right] - count[left] > k){
            boolean deleteLeft = left(count, left, right, k);
            if(deleteLeft){
                deleted += count[left];
                left++;
            }else {
                if(count[right] - count[left] - count[left] < k){
                    deleted += count[right] - count[left] - k;
                    count[right] = count[left] + k;
                    while (right > left && count[right] <= count[right-1])
                        right--;
                }else{
                    count[right] = count[right] - count[left];
                    deleted += count[left];
                    while (right > left && count[right] <= count[right-1])
                        right--;
                }
            }
        }
        return deleted;

    }

    private static boolean left(int[] count, int left, int right, int k){

        int numberToRemove = count[left];
        //left delete
        int newDiffLeftDelete = count[right] - count[left+1];
        if(count[right] - numberToRemove - count[left] < k){
            return false;
        }
        int newRight = count[right] - numberToRemove;
        int i = right;
        while (i>left && newRight <= count[i-1]) {
            i--;
            newRight = count[i];
        }
        int newDiffRightReduce = newRight - count[left];

        return newDiffLeftDelete <= newDiffRightReduce;

    }

}
