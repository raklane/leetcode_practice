import java.util.HashSet;
import java.util.Set;

public class Leetcode3_2 {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int curr = 0;
        int max = 0;

        while (right < arr.length){

            if(!set.contains(arr[right])){
                set.add(arr[right]);
                curr++;
            }else{
                char dup = arr[right];
                max = Math.max(max, curr);
                int temp = right-1;
                Set<Character> tempSet = new HashSet<>();
                tempSet.add(arr[right]);
                while (arr[temp] != dup){
                    tempSet.add(arr[temp]);
                    temp--;
                }
                for (int i = left; i <= temp; i++) {
                    if(!tempSet.contains(arr[i]))
                        set.remove(arr[i]);
                }
                left = temp+1;
                curr = right-left+1;
            }
            right++;

        }
        return Math.max(max, curr);

    }

}
