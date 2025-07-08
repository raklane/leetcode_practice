import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    public static void main(String[] args){
        List<List<Integer>> list = combine(4,2);
        System.out.println("Rakesh");
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> list = new ArrayList<>();
        if(k>n)
            return list;
        generateCombinations(list, new ArrayList<>(), n, k, 1);
        return list;

    }

    private static void generateCombinations(List<List<Integer>> list, List<Integer> currentList, int n, int k, int index){

        if(index>n)
            return;

        currentList.add(index);

        if(currentList.size()==k) {
            list.add(new ArrayList<>(currentList));
            currentList.removeLast();
            generateCombinations(list,currentList,n,k,index+1);
            return;
        }

        generateCombinations(list,currentList,n,k,index+1);
        currentList.removeLast();
        generateCombinations(list,currentList,n,k,index+1);

    }
}
