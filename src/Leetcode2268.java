import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2268 {
    public static void main(String[] args){
        System.out.println(minimumKeypresses("apple"));
    }

    public static int minimumKeypresses(String s) {

        Map<Character,Integer> charCount = new HashMap<>();
        Map<Integer, List<Character>> numberMap = new HashMap<>();
        int maxOccurance = 0;

        for (char c : s.toCharArray()){
            Integer currentCount = charCount.get(c);
            int newCharacterCount;
            if(currentCount == null) {
                newCharacterCount = 1;
                List<Character> characters = numberMap.get(1);
                if(characters == null)
                    characters = new ArrayList<>();
                characters.add(c);
                numberMap.put(newCharacterCount, characters);
            }
            else {
                newCharacterCount = currentCount + 1;
                numberMap.get(currentCount).remove((Character) c);
                List<Character> characters = numberMap.get(newCharacterCount);
                if(characters == null)
                    characters = new ArrayList<>();
                characters.add(c);
                numberMap.put(newCharacterCount, characters);
            }
            maxOccurance = Math.max(maxOccurance, newCharacterCount);
            charCount.put(c, newCharacterCount);

        }

        int[] keypad = new int[9];
        boolean[] charMapped = new boolean[26];
        int currentButton = 0;
        int keyPresses = 0;
        while (maxOccurance != 0){

            List<Character> charList = numberMap.get(maxOccurance);
            if(charList == null)
                continue;
            for(char c : charList){
                if(!charMapped[c-'a']){
                    keypad[currentButton]++;
                    charMapped[c-'a'] = true;
                }
                keyPresses = keyPresses + maxOccurance * keypad[currentButton];
                currentButton = currentButton == 8? 0: currentButton+1;
            }
            maxOccurance--;
        }


        return keyPresses;
    }
}
