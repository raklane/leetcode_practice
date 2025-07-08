import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode3443 {

    public static void main(String[] args){
        System.out.println(maxDistance("NWSE", 1));
    }

    public static int maxDistance(String s, int k) {

        int vertical = 0;
        int horizontal = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case 'N':
                    vertical++;
                    break;
                case 'S':
                    vertical--;
                    break;
                case 'E':
                    horizontal++;
                    break;
                case 'W':
                    horizontal--;
                    break;
            }

            ans = Math.max(ans, Math.min(Math.abs(vertical) + Math.abs(horizontal) + k*2, i+1));

        }

        return ans;

    }

}
