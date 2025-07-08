import java.util.*;

public class Leetcode139 {

    public static void main(String[] args){
        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict,"car","ca","rs");
        System.out.println(wordBreak("cars", wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return checkWords(s,wordDict,0,new HashMap<>());
    }

    public static boolean checkWords(String s, List<String> wordDict, int wordListIndex, Map<String,Boolean> map){

        if(s.isEmpty())
            return true;

        if(wordListIndex >= wordDict.size())
            return false;

        String word = wordDict.get(wordListIndex);

        if(map.containsKey(word)){
            return checkWords(s,wordDict,wordListIndex+1,map);
        }

        String replacedString = s;
        boolean ans = false;
        if(replacedString.contains(word)){
            replacedString = replacedString.replaceAll(word,"");
            map.put(word,true);
            ans = checkWords(replacedString,wordDict, wordListIndex+1,map);
        }
        ans = ans || checkWords(s,wordDict, wordListIndex+1,map);
        return ans;

    }
}
