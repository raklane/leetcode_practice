import java.util.Arrays;

public class Leetcode72_2 {

    public int minDistance(String word1, String word2) {

        int[][] memo = new int[word1.length()][word2.length()];
        return backtrack(word1, word2, 0, 0, memo);

    }

    public int backtrack(String word1, String word2, int index1, int index2, int[][] memo){

        if(index1 == word1.length() && index2 == word2.length())
            return 0;

        if(index1 == word1.length())
            return word2.length() - index2;
        else if(index2 == word2.length())
            return word1.length() - index1;

        if(memo[index1][index2] != 0)
            return memo[index1][index2];

        if(word1.charAt(index1) == word2.charAt(index2)) {
            memo[index1][index2] = backtrack(word1, word2, index1 + 1, index2 + 1, memo);
        }
        else {
            int added = backtrack(word1, word2, index1+1, index2 + 1, memo);
            int deleted = backtrack(word1, word2, index1+1, index2, memo);
            int inserted = backtrack(word1, word2, index1, index2+1, memo);

            memo[index1][index2] =  1 + Math.min(added, Math.min(deleted, inserted));
        }
        return memo[index1][index2];

    }

}

/*
horse   ros
horss   hors    horses
horos
 */