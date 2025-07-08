import java.util.*;

public class Leetcode139_2 {

    public static void main(String[] args){
        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict,"car","ca","rs");
        System.out.println(wordBreak("cars", wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.isEmpty())
            if(!s.isEmpty())
                return false;
            else
                return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        List<String> seen = new ArrayList<>();
        return bfs(s,wordDict,queue,seen);
    }

    public static boolean bfs(String s, List<String> wordDict, Queue<Integer> queue, List<String> seen){

        if(s.isEmpty())
            return true;

        String sCopy = s;
        while (!queue.isEmpty()){

            int index = queue.poll();
            String word = wordDict.get(index);
            if(seen.contains(word))
                continue;
            seen.add(word);
            sCopy = sCopy.replaceAll(word, "");
            boolean ans1 = bfs(s,wordDict,queue,seen);
            boolean ans2 = bfs(s,wordDict,queue,seen);

        }
        return false;
    }
}
