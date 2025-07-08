public class Leetcode1147 {

    public static void main(String[] args){
        System.out.println(longestDecomposition(""));
    }

    public static int longestDecomposition(String text) {

        int start = 0;
        int end = text.length();
        int subStringCount = 0;

        while (start < end){

            int count = helper(text, start, end);
            if(count == end - start){
                subStringCount++;
                break;
            }
            subStringCount += 2;
            start += count;
            end -= count;

        }

        return subStringCount;

    }


    public static int helper(String text, int start, int end){

        int count = 1;
        while (start + count <= end - count){

            String leftWord = text.substring(start, start+count);
            String rightWord = text.substring(end-count, end);

            if(leftWord.equals(rightWord))
                return count;

            count++;

        }

        return end-start;

    }
}
