import java.util.ArrayList;
import java.util.List;

public class Leetcode653 {

    public static void main(String[] args){

    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        addNodesToList(list,root);
        for (int i = 0; i < list.size(); i++) {
            int remaining = k-list.get(i);
            int index = list.indexOf(remaining);
            if(index !=-1 && index !=i)
                return true;
        }
        return false;
    }

    public void addNodesToList(List<Integer> list, TreeNode node){
        if(node==null)
            return;
        list.add(node.val);
        addNodesToList(list,node.left);
        addNodesToList(list,node.right);
    }

}
