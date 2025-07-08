public class Leetcode443 {

    public static void main(String[] args){
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }

    public static int compress(char[] chars) {

        int left = 0;
        int right = 0;

        while (right < chars.length) {
            int count = 0;

            while (right < chars.length && chars[left] == chars[right]){
                count++;
                right++;
            }
            if(count > 1){
                String countLength = String.valueOf(count);
                for(char c : countLength.toCharArray()){
                    chars[++left] = c;
                }
            }

            if(right != chars.length){
                chars[++left] = chars[right];
            }

        }
        return left+1;

    }

}
