import java.util.*;

public class Leetcode127_2 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");

        System.out.println(ladderLength("qa","sq",list));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if(currentWord.equals(endWord))
                    return level;
                List<String> neighbors = generateNeighbors(currentWord);
                for(String neighbor : neighbors){
                    if(words.contains(neighbor)){
                        words.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    private static List<String> generateNeighbors(String currentWord) {
        List<String> list = new ArrayList<>();
        char[] c = currentWord.toCharArray();
        for (int i = 0; i < c.length; i++) {
            char temp = c[i];
            for(char c1 = 'a'; c1<='z'; c1++){
                c[i] = c1;
                String str = new String(c);
                list.add(str);
            }
            c[i]=temp;
        }
        return list;
    }


}