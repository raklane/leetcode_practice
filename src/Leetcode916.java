import java.util.*;

public class Leetcode916 {

    public static void main(String[] args){
        System.out.println(wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"lo","eo"}));
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {

        List<Map<Character,Integer>> listOfMap = new ArrayList<>();

        for (String word : words1){
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int count = map.getOrDefault(c, 0);
                map.put(c, count+1);
            }
            listOfMap.add(map);
        }

        List<Map<Character,Integer>> listOfMap2 = new ArrayList<>();

        for (String word : words2){
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int count = map.getOrDefault(c, 0);
                map.put(c, count+1);
            }
            listOfMap2.add(map);
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < listOfMap.size(); i++) {
            boolean found = true;
            Map<Character, Integer> map = listOfMap.get(i);
            for (int j = 0; j < listOfMap2.size() && found; j++) {
                Map<Character, Integer> map2 = listOfMap2.get(j);
                for(char c : map2.keySet()){
                    if(map.get(c) == null || map.get(c) < map2.get(c)) {
                        found = false;
                        break;
                    }
                }
            }

            if(found)
                result.add(words1[i]);
        }

        return result;

    }

}
