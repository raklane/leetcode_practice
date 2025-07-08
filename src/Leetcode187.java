import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode187 {

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> currentSequences = new HashSet<>();
        Set<String> result = new HashSet<>();

        int left = 0;
        int right = 10;
        while (right <= s.length()){
            String str = s.substring(left, right);
            if(currentSequences.contains(str))
                result.add(str);
            else
                currentSequences.add(str);
            left++;
            right++;
        }
        return new ArrayList<>(result);

    }

}
