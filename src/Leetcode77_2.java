import java.util.ArrayList;
import java.util.List;

public class Leetcode77_2 {

    public static void main(String[] args){
        List<List<Integer>> list = combine(4, 2);
        for (List<Integer> subList : list){
            for(int num : subList){
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> list = new ArrayList<>();
        backtrack(n, k, new ArrayList<>(), list, 1);
        return list;

    }

    public static void backtrack(int n, int k, List<Integer> currentList, List<List<Integer>> list, int i){

        if(i>n)
            return;

        currentList.add(i);
        if(currentList.size() == k){
            list.add(new ArrayList<>(currentList));
            currentList.removeLast();
            backtrack(n, k, currentList, list, i+1);
            return;
        }

        backtrack(n, k, currentList, list, i+1);
        currentList.removeLast();
        backtrack(n, k, currentList, list, i+1);

    }


}

/*
1 2
1
2

1   2   3   4
1   2
1   3
1   4
2   3
2   4
3   4

1 2 3 4 5
1 2 3
1 2 4
1 2 5
1 3 4
1 3 5
2 3 4
2 4 5

 */
