import java.util.ArrayList;
import java.util.List;

public class Leetcode2476 {

    public static void main(String[] args){

    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<List<Integer>> list = new ArrayList<>();
        for (Integer query : queries) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(findMin(root, query, -1));
            currentList.add(findMax(root, query, -1));
            list.add(currentList);
        }
        return list;

    }

    private static int findMin(TreeNode node, int n, int previousNodeVal){
        if(node==null)
            return previousNodeVal;
        if(node.val == n)
            return node.val;
        else if(node.val>n)
            return findMin(node.left,n,previousNodeVal);
        else {
            previousNodeVal = node.val;
            return findMin(node.right,n,previousNodeVal);
        }
    }

    private static int findMax(TreeNode node, int n, int previousNodeVal){
        if(node==null)
            return previousNodeVal;
        if(node.val == n)
            return node.val;
        else if(node.val<n)
            return findMax(node.right,n,previousNodeVal);
        else {
            previousNodeVal = node.val;
            return findMax(node.left,n,previousNodeVal);
        }
    }


}
