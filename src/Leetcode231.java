public class Leetcode231 {

    public static void main(String[] args){
        System.out.println(isPowerOfTwo(1073741825));
    }

    public static boolean isPowerOfTwo(int n) {

        int num = 1;
        while (num < n && num >0){
            num *= 2;
        }
        return num == n;

    }

}
