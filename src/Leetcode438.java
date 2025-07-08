import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode438 {

    public static void main(String[] args){
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {


        List<Integer> list = new ArrayList<>();
        char[] arr = p.toCharArray();
        Arrays.sort(arr);
        p = new String(arr);

        int pLen = p.length();
        for (int i = 0; i <= s.length()-pLen; i++) {
            arr = new char[pLen];
            for (int j = i; j < i+pLen; j++) {
                arr[j-i] = s.charAt(j);
            }
            Arrays.sort(arr);
            String str = new String(arr);
            if(str.equals(p))
                list.add(i);
        }
        return list;
    }

}
