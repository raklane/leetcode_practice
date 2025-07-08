import java.util.*;

public class Leetcode49 {

    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List< List<String>> list = new ArrayList<>();
        List<Integer> indexesCovered = new ArrayList<>();

        for (int i = 0; i < strs.length && !indexesCovered.contains(i); i++) {
            String str = strs[i];
            List<String> stringList = backtrack(str,new ArrayList<String>(),new ArrayList<Integer>(),new StringBuilder());
            List<String> anagramsStrings = new ArrayList<>();
            HashSet<Integer> anagramsIndices = new HashSet<>();
            for(String strFromList : stringList){
                anagramsIndices.addAll(exists(strs,strFromList));
            }
            for(int currentIndex : anagramsIndices){
                indexesCovered.add(currentIndex);
                anagramsStrings.add(strs[currentIndex]);
            }
            list.add(anagramsStrings);
        }
        return list;

    }

    private List<String> backtrack(String str, ArrayList<String> tempList, ArrayList<Integer> indexesCovered, StringBuilder sb){
        if(sb.length() == str.length()) {
            tempList.add(sb.toString());
            indexesCovered.clear();
        }else{
            for (int i = 0; i < str.length(); i++) {
                if(indexesCovered.contains(i)) continue;
                indexesCovered.add(i);
                sb.append(str.charAt(i));
                backtrack(str,tempList,indexesCovered,sb);
                sb.deleteCharAt(sb.length()-1);
                indexesCovered.removeLast();
            }
        }
        return tempList;
    }

    private HashSet<Integer> exists(String[] strs, String str){
        HashSet<Integer> returnIndices = new HashSet<Integer>();
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].equals(str))
                returnIndices.add(i);
        }
        return returnIndices;
    }


}
