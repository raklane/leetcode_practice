public class Leetcode72 {
    public static void main(String[] args){
        System.out.println();
    }
    public int minDistance(String word1, String word2) {

        int[][] memo = new int[word1.length()][word2.length()];
        return compareStrings(word1, word2, word1.length()-1, word2.length()-1, memo);

    }

    public int compareStrings(String word1, String word2, int word1Index, int word2Index, int[][] memo){

        //no more letters remaining
        if(word1Index == -1 && word2Index == -1)
            return 0;

        //word2 has some remaining characters that need to be added to word1
        if(word1Index == -1 && word2Index > -1)
            return word2Index+1;

        //word1 has some remaining characters that need to be deleted
        if(word1Index > -1 && word2Index == -1)
            return word1Index+1;

        if(memo[word1Index][word2Index] != 0)
            return memo[word1Index][word2Index];

        //equal letters
        if(word1.charAt(word1Index) == word2.charAt(word2Index))
            return compareStrings(word1, word2, word1Index-1, word2Index-1, memo);

        int deleteResult = compareStrings(word1, word2, word1Index-1, word2Index, memo);
        int insertResult = compareStrings(word1, word2, word1Index, word2Index-1, memo);
        int replaceResult = compareStrings(word1, word2, word1Index-1, word2Index-1, memo);
        int minDistance = 1+Math.min(Math.min(deleteResult, insertResult) , replaceResult);
        memo[word1Index][word2Index] = minDistance;
        return minDistance;

    }
}
