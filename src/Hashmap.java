import java.util.HashMap;
import java.util.Map;

public class Hashmap {

    public static void main(String[] args){

        Map<Character,Integer> map = new HashMap<>();
        map.put('a',9);
        map.put('b',5);
        map.put('z',3);
        map.put('c',0);

        for(char c : map.keySet()){
            System.out.println(c + "\t" + map.get(c));
        }

    }

}
