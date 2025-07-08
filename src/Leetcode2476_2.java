import java.util.ArrayList;
import java.util.List;

public class Leetcode2476_2 {

    public static void main(String[] args){

    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arrList = new ArrayList<>();
        storeTreeToSortedArray(root,arrList);
        Integer[] arr = arrList.toArray(new Integer[0]);

        for(int query : queries){
            int l = 0;
            int r = arr.length-1;
            int mid = (l+r)/2;
            while (l<=r){
                if(arr[mid] == query)
                    break;
                else if(arr[mid]>query){
                    r = mid-1;
                }
                else {
                    l=mid+1;
                }
                mid=(l+r)/2;
            }
            List<Integer> currentList = new ArrayList<>();
            if(mid == query){
                currentList.add(arr[mid]);
                currentList.add(arr[mid]);
            }else{
                if(l<1)
                    currentList.add(-1);
                else
                    currentList.add(arr[l-1]);
                if(l>arr.length-1)
                    currentList.add(-1);
                else
                    currentList.add(arr[l+1]);
            }
            list.add(currentList);
        }

        return list;

    }

    public static void storeTreeToSortedArray(TreeNode node, List<Integer> list){

        if(node==null)
            return;
        storeTreeToSortedArray(node.left,list);
        list.add(node.val);
        storeTreeToSortedArray(node.right,list);

    }


}
